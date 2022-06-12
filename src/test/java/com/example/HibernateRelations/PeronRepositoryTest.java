package com.example.HibernateRelations;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class PeronRepositoryTest {
    @Autowired
    PeronRepository personRepository;
    @Autowired
    AddressRepository addressRepository;
    public void init(){
        personRepository.save(new Person("Krzysztof", "Telefon",30,new Address("Zielona","Zakopane","32-987","3")));
        personRepository.save(new Person("Zbigniew", "Komórka",30,new Address("Błękitna","Gdańsk","12-123","9")));

    }
    @Test
    public void shouldAddAddressFromPerson(){
        //given
        init();
        //when
        assertThat(personRepository.findAll().size()).isEqualTo(2);
        assertThat(addressRepository.findAll().size()).isEqualTo(2);

    }

}