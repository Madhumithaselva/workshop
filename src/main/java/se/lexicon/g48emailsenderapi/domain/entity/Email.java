package se.lexicon.g48emailsenderapi.domain.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Email {

    @Id
    @GeneratedValue(Generator="UUID")
    @GenericGenerator(name="UUID",strategy="org.hibernate.id.UUIDGenerator")
    private String id;
    @Column(name = "_to",nullable = false)
    private String to;
    @Column(name="_from",nullable = false)
    private String from;
    @Lob
    @Column(length=6500)
    private String content;
    @Column(nullable = false)
    private String subject;
    @Lob
    private List<String> attachment;
    private LocalDateTime dateTime;
    @PrePersist
    public void initialDate(){
        dateTime=LocalDateTime.now();
    }

}
