package com.example.HibernateRelations;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

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

     @Test
     public void changeNameOfStreet (){
      //given
         Address address1 =new Address("Kraków", "Wietrzna", "31-209","10");
         Person person = new Person("Zbigniew", "Wichura",39,address1);
         Person operation = personRepository.save(person);

      //when
         operation.getAddress().setStreet("Huraganowa");
         Optional<Address> adres = addressRepository.findOneByStreet("Huraganowa");
      //then
         assertThat(adres.isPresent()).isTrue();

  }
  @Test
  public void should(){
      //given
      Address address = new Address("Strzelista","Ciechocinek","65-211","3");
      Address address1 = new Address("Franciszkańska","Ciechocinek","65-221","6");
      Person person = new Person("Paweł","Sad",37,address);
      Person person1 = new Person("Mariusz","Gad",29,address1);


      //when

      //then

  }

}