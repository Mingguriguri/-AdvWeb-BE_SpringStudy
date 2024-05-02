package gcu.msa.restpost.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    private Long id;
    private String Name;

    @Override
    public String toString() {
        return "User{" +
                "Name='" + Name + '\'' +
                ", id=" + id +
                '}';
    }
}
