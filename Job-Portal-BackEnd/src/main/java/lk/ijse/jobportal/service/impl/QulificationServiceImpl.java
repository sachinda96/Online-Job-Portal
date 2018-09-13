package lk.ijse.jobportal.service.impl;

import lk.ijse.jobportal.repository.QulificationRepository;
import lk.ijse.jobportal.service.QulificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class QulificationServiceImpl implements QulificationService {

    @Autowired
    private QulificationRepository qulificationRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean deleteQulification(Long id) {
        qulificationRepository.deleteById(id);
        return true;
    }
}

