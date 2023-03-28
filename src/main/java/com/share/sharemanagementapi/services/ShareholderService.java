package com.share.sharemanagementapi.services;

import com.share.sharemanagementapi.domains.Shareholder;
import com.share.sharemanagementapi.repositories.ShareholderRepository;
import com.share.sharemanagementapi.utils.DuplicationCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShareholderService {
    // here we need the repository then we can not instantiate repo here
    //YOU CANNOT DO THIS! ShareholderRepository shareholderRepository = new ShareholderRepository();
    // then we use Singleton Pattern  is who have @annotation
    @Autowired
    private ShareholderRepository shareholderRepository;

    // this method accept Shareholders Object and return Shareholders
    public Shareholder registerShareholder(Shareholder shareholder) throws Exception {
        // here we can write validation and if we throw exception here in the service we have to catch it in Controller
        Boolean IsphoneExist = DuplicationCheck.findPhoneNumber(shareholder.getPhoneNumber());
        if(IsphoneExist == true) {
            throw new Exception("Phone Number is Exist");
        }

        return shareholderRepository.save(shareholder);
    }
}
