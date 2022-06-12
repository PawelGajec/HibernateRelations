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

    public void init(){
        personRepository.save(new Person("Krzysztof", "Telefon",30,new Address("Zielona","Zakopane","32-987","3")));
        personRepository.save(new Person("Zbigniew", "Komórka",30,new Address("Błękitna","Gdańsk","12-123","9")));

    }
    @Test
    public void shouldAddAddressFromPerson(){
        //given
        init();
        //when
        List<Person> personWithAddress = personRepository.getAddNewAddress(new Address("Zółta","Katowice","32-133","87"));
        //then
        assertThat(personWithAddress.size()).isEqualTo(3);
    }

}