package ru.alexbykov.chat.api.models.user;

/**
 * Date: 04.08.2017
 * Time: 21:18
 * Project: ChatExample
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 *         <p>
 *         Данная модель — сокращённый профильпользователя.
 *         Используем в списках + в пагинации, чтобы не гонять по сети
 *         лишние данные
 */
public class PersonDTO {

    private String name;
    private String lastName;
    private String photoUrl;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
