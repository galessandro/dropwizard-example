package org.example.useridcard;

public class UserIdCardDTO {

    private String cardNumber;

    public UserIdCardDTO(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public UserIdCardDTO() {
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "UserIdCardDTO{" +
                "cardNumber='" + cardNumber + '\'' +
                '}';
    }
}
