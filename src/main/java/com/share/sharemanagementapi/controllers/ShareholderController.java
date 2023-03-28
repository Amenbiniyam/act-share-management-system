package com.share.sharemanagementapi.controllers;

import com.share.sharemanagementapi.domains.Shareholder;
import com.share.sharemanagementapi.services.ShareholderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ShareholderController {

    @Autowired
    private ShareholderService shareholderService;
    @PostMapping("/api/shareholders")
    public ResponseEntity<?> createShareholder(@RequestBody Shareholder shareholder) throws Exception {
        try {
            Shareholder saveShareholder =  shareholderService.registerShareholder(shareholder);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(saveShareholder);
        }
        catch (Exception ex) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":" + ex.getMessage() + "}");
        }
    }

}
