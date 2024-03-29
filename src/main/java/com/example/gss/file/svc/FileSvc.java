package com.example.gss.file.svc;

import com.example.gss.common.Excel;
import com.example.gss.common.FilePath;
import com.example.gss.file.dao.FileDao;
import com.example.gss.file.dto.FileEnroll;
import com.example.gss.file.dto.res.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class FileSvc {

    @Autowired
    private FileDao fileDao;

    @Transactional(rollbackFor = {IOException.class, InvalidFormatException.class, Exception.class})
    public List<FileOrderInfoResList> orderExcelUpload(List<MultipartFile> files) throws IOException, InvalidFormatException {
        List<FileOrderInfoResList> resultList = new ArrayList<>();
        for(MultipartFile file: files){

            FileOrderInfoResList result = new FileOrderInfoResList();
            List<FileOrderInfo> list = new ArrayList<>();

            String fileId = UUID.randomUUID().toString();
            FileEnroll fileEnroll = new FileEnroll();
            fileEnroll.setFileId(fileId);
            fileEnroll.setFilePath(FilePath.TMP_PATH.getPath());
            fileEnroll.setFileName(file.getOriginalFilename());

            fileDao.insertFile(fileEnroll);
            result.setFileId(fileId);

            OPCPackage opcPackage = OPCPackage.open(file.getInputStream());
            XSSFWorkbook workbook = new XSSFWorkbook(opcPackage);
            int sheetCount = workbook.getNumberOfSheets();
            for(int i = 0 ; i < sheetCount; i ++){
                Row row = null;
                FileOrderInfo info = new FileOrderInfo();
                XSSFSheet sheet = workbook.getSheetAt(i);

                row = sheet.getRow(Excel.ORGANIZATION.getRow());
                String orgTmpName = row.getCell(Excel.ORGANIZATION.getCell()).toString();
                info.setOrgInfos(fileDao.selectOrgInfos(orgTmpName));

                row = sheet.getRow(Excel.ORDERING_DATE.getRow());
                info.setOrderingDaTe(row.getCell(Excel.ORDERING_DATE.getCell()).toString());

                row = sheet.getRow(Excel.DEAD_LINE_DATE.getRow());
                info.setDeadLineDate(row.getCell(Excel.DEAD_LINE_DATE.getCell()).toString());

                int currentRow = 11;
                String tmpStyleNo = "";
                String tmpItem = "";
                String tmpSize = "";
                String tmpColor = "";
                String tmpQty = "";

                List<FileProduct> products = new ArrayList<>();

                while(true){
                    if(currentRow >= 50){
                        break;
                    }
                    FileProduct dto = new FileProduct();
                    row = sheet.getRow(currentRow);

                    String styleNo =  row.getCell(Excel.STYLE_NO.getCell()).toString();
                    if("합  계".equals(styleNo)){
                        break;
                    }
                    if(StringUtils.isEmpty(styleNo)){
                        styleNo = tmpStyleNo;
                    }else{
                        tmpStyleNo = styleNo;
                    }

                    String item = row.getCell(Excel.ITEM.getCell()).toString();
                    if(StringUtils.isEmpty(item)){
                        item = tmpItem;
                    }else{
                        tmpItem = item;
                    }

                    String size = row.getCell(Excel.SIZE.getCell()).toString();
                    if(StringUtils.isEmpty(size)){
                        size = tmpSize;
                    }else{
                        tmpSize = size;
                    }

                    String color = row.getCell(Excel.COLOR.getCell()).toString();
                    if(StringUtils.isEmpty(color)){
                        color = tmpColor;
                    }else{
                        tmpColor = color;
                    }

                    String qty = row.getCell(Excel.QTY.getCell()).toString();
                    if(StringUtils.isEmpty(qty)){
                        qty = tmpQty;
                    }else{
                        tmpQty = qty;
                    }

                    dto.setColor(color);
                    dto.setQty(qty);
                    dto.setItem(item);
                    dto.setSize(size);
                    dto.setStyleNo(styleNo);
                    products.add(dto);

                    currentRow++;
                }
                info.setProducts(products);
                list.add(info);
            }
            File path = new File(FilePath.TMP_PATH.getPath());
            if(!path.exists()){
               path.mkdirs();
            }

            File fileClass = new File(FilePath.TMP_PATH.getPath() + "\\" + fileId +".xlsx");

            FileOutputStream out = new FileOutputStream(fileClass);
            workbook.write(out);
            workbook.close();
            out.close();
            result.setList(list);
            resultList.add(result);
        }
        return resultList;
    }

    public FileResList selectFiles(){
        FileResList result = new FileResList();

        List<FileRes> list = fileDao.selectFiles();
        Integer count = fileDao.selectFilesCount();

        result.setList(list);
        result.setTotalCount(count);

        return result;
    }

    public FileDetailRes selectFileDetail(String fileId){

        FileDetailRes result = fileDao.selectFileDetail(fileId);

        List<FileDetailOrderRes> orders = fileDao.selectFileDetailOrders(fileId);

        result.setList(orders);

        return result;
    }


}
