package org.example.useridcard;

public class UserIdCardInsertDTO {

    private String cardNumber;

    public UserIdCardInsertDTO(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public UserIdCardInsertDTO() {
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "UserIdCardInsertDTO{" +
                "cardNumber='" + cardNumber + '\'' +
                '}';
    }
}
