package com.example.gss.file.ctrl;

import com.example.gss.file.dto.FileOrderInfoList;
import com.example.gss.file.svc.FileSvc;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/file")
@Tag(name = "발주서 관리")
public class FileCtrl {


    @Autowired
    private FileSvc fileSvc;
    @PostMapping(value = "", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FileOrderInfoList> uploadOrderExcel(@RequestPart List<MultipartFile> files){

        FileOrderInfoList result = fileSvc.orderExcelUpload(files);

        return new ResponseEntity<>(result,HttpStatus.OK);
    }


}
