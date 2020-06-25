package entities;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Objects;

/**
 * The type Results entity.
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "RESULTS")
public class ResultsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "WORDS", nullable = false)
    private String words;

    @Column(name = "WORDS_QUANTITY", nullable = false)
    private int words_quantity;

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets words.
     *
     * @return words
     */
    public String getWords() {
        return words;
    }

    /**
     * Sets words.
     *
     * @param operation the operation
     */
    public void setWords(String operation) {
        this.words = operation;
    }

    /**
     * Gets words quantity.
     *
     * @return the words quantity
     */
    public int getWords_quantity() {
        return words_quantity;
    }

    /**
     * Sets words quantity.
     *
     * @param result the result
     */
    public void setWords_quantity(int result) {
        this.words_quantity = result;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultsEntity that = (ResultsEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(words, that.words) &&
                Objects.equals(words_quantity, that.words_quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, words, words_quantity);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ResultsEntity{");
        sb.append("id=").append(id);
        sb.append(", words'").append(words).append('\'');
        sb.append(", words_quantity='").append(words_quantity).append('\'');
        sb.append('}');
        return sb.toString();
    }

    /**
     * Instantiates a new Results entity.
     *
     * @param id             the id
     * @param words           the words
     * @param words_quantity the words quantity
     */
    public ResultsEntity(long id, String words, int words_quantity){
        this.id = id;
        this.words = words;
        this.words_quantity = words_quantity;
    }

    public ResultsEntity(String words, int words_quantity){
        this.words = words;
        this.words_quantity = words_quantity;
    }

    /**
     * Instantiates a new Results entity.
     */
    public ResultsEntity(){

    }
}
