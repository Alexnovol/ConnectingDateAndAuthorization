package entity;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Book {

    private long id;
    private String bookTitle;
    private long authorId;
    private LocalDate updated;
}
