package jpabook.jpashop.domain;
import jakarta.persistence.Embeddable;
import lombok.Getter;
@Embeddable
@Getter
// 값 타입은 Immutable 하게 설정 -> Setter 제거, 기본 생성자 protected
public class Address {
    private String city;
    private String street;
    private String zipcode;
    // 불변 가능하도록 생성자 protected
    protected Address() {
    }
    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}