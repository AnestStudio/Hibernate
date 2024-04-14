package entity;

import dto.UserDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

//@SqlResultSetMapping(
//    name="UserResult",
//    entities={
//        @EntityResult(
//            entityClass = User.class,
//            fields={@FieldResult(name="id", column="employeeNumber"),
//                    @FieldResult(name="name", column="name")}
//        )
//    }
//)

//@NamedNativeQueries({
//    @NamedNativeQuery(
//        name="FindUsers",
//        query="SELECT * FROM [user]"
//    ),
//    @NamedNativeQuery(
//        name="FindUserByUsernameAndPassword",
//        query="SELECT username, password FROM [user]"
//    )
//})

//@NamedNativeQuery(
//    name="FindUsers",
//    query="SELECT * FROM [user]"
//)
//@NamedNativeQuery(name = "FindUserById",
//        query = "SELECT * FROM [User] WHERE user_id = ?",
//        resultClass = User.class
//)

//@NamedNativeQuery(
//    name="FindUserByUsernameAndPassword",
//    query="SELECT username, password FROM [user]",
//    resultSetMapping = "UsernameAndPasswordDTO"
//)
//@SqlResultSetMapping(
//    name = "UsernameAndPasswordDTO",
//    classes = @ConstructorResult(
//        targetClass = UserDTO.class,
//        columns = {
//            @ColumnResult(name = "username"),
//            @ColumnResult(name = "password")
//        }
//    )
//)

@NamedNativeQuery(
    name="SelectUsersCustomMapping",
    query="SELECT u.user_id as id, u.username as account, u.password, u.created_at, u.modified_at FROM [user] u",
    resultSetMapping = "UserCustomMapping"
)
@SqlResultSetMapping(
    name = "UserCustomMapping",
    entities = @EntityResult(
        entityClass = User.class,
        fields = {
            @FieldResult(name = "userId", column = "id"),
            @FieldResult(name = "username", column = "account"),
            @FieldResult(name = "password", column = "password"),
            @FieldResult(name = "createdAt", column = "created_at"),
            @FieldResult(name = "modifiedAt", column = "modified_at")
        }
    )
)
@Data
@Entity
@Table(name = "[user]")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column
    private String username;

    @Column
    private String password;

    @Column(name = "created_at")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "modified_at")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date modifiedAt;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserDetail userDetail;
}
