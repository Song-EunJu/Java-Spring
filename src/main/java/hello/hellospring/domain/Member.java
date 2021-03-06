package hello.hellospring.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Member {

    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    // db가 알아서 생성해주는 것은 identity = 아까 id 번호
    private Long id; // 시스템에 저장할 때 시스템이 정하는 id

    private String name; // 고객이 회원가입할 때 입력하는 이름

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
