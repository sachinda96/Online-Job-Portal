package lk.ijse.jobportal.service.impl;

import lk.ijse.jobportal.repository.CategoryRepository;
import lk.ijse.jobportal.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository qualificationRepository;

    @Override
    public ResponseEntity<?> getAll() {

        try {

            return new ResponseEntity<>(qualificationRepository.findAll(), HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
