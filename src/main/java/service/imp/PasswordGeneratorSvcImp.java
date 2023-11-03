package service.imp;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import model.ResponseApi;
import service.inter.PasswordGeneratorSvcInter;

@RequestScoped
public class PasswordGeneratorSvcImp implements PasswordGeneratorSvcInter {

    @Inject
    PasswordGenerator generator;

    @Override
    public ResponseApi generatePassword() {
        try {

            return new ResponseApi("Success", 200, generator.generatePassword(25));
        } catch (Exception e) {
            return new ResponseApi("Error", 500, e.getMessage());
        }
    }

}
