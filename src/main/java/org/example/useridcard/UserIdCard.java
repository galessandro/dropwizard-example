package org.example.useridcard;

import jakarta.persistence.*;

@Entity(name = "UserIdCard")
@Table(name = "user_id_card")
public class UserIdCard {

    @Id
    @SequenceGenerator(
            name = "user_id_card_sequence",
            sequenceName = "user_id_card_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_id_card_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "card_number",
            nullable = false,
            length = 15
    )
    private String cardNumber;

    public UserIdCard(Long id, String cardNumber) {
        this.id = id;
        this.cardNumber = cardNumber;
    }

    public UserIdCard() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "UserIdCard{" +
                "id=" + id +
                ", cardNumber='" + cardNumber + '\'' +
                '}';
    }
}
