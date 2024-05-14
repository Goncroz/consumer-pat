package br.com.alelo.consumer.consumerpat.service;

import br.com.alelo.consumer.consumerpat.entity.ContactInfo;

import br.com.alelo.consumer.consumerpat.respository.ContactInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactInfoService {

    private final ContactInfoRepository contactInfoRepository;

    @Autowired
    public ContactInfoService(ContactInfoRepository contactInfoRepository) {
        this.contactInfoRepository = contactInfoRepository;
    }

    public ContactInfo findById(Long id) {
        return contactInfoRepository.findById(id).orElse(null);
    }

    public ContactInfo findByMobilePhoneNumber(Long mobilePhoneNumber) {
        return contactInfoRepository.findByMobilePhoneNumber(mobilePhoneNumber);
    }

    public ContactInfo findByResidencePhoneNumber(Long residencePhoneNumber) {
        return contactInfoRepository.findByResidencePhoneNumber(residencePhoneNumber);
    }

    public ContactInfo findByPhoneNumber(Long phoneNumber) {
        return contactInfoRepository.findByPhoneNumber(phoneNumber);
    }

    public ContactInfo findByEmail(String email) {
        return contactInfoRepository.findByEmail(email);
    }

    public ContactInfo getContactInfoById(Long id) {
        return null;
    }
}
