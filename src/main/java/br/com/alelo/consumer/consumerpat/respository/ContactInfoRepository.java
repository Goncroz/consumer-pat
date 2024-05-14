package br.com.alelo.consumer.consumerpat.respository;

import br.com.alelo.consumer.consumerpat.entity.ContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactInfoRepository extends JpaRepository<ContactInfo, Long> {

    ContactInfo findById(long id);

    ContactInfo findByMobilePhoneNumber(Long mobilePhoneNumber);

    ContactInfo findByResidencePhoneNumber(Long residencePhoneNumber);

    ContactInfo findByPhoneNumber(Long phoneNumber);

    ContactInfo findByEmail(String email);
}
