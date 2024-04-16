package entity;

import dto.UserDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

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
//@NamedNativeQuery(
//    name = "FindUserById",
//    query = "SELECT * FROM [User] WHERE user_id = ?",
//    resultClass = User.class
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
//            @ColumnResult(name="username"),
//            @ColumnResult(name="password")
//        }
//    )
//)

//@NamedNativeQuery(
//    name="SelectUsersCustomMapping",
//    query="SELECT u.user_id as id, u.username as account, u.password, u.created_at, u.modified_at FROM [user] u",
//    resultSetMapping = "UserCustomMapping"
//)
//@SqlResultSetMapping(
//    name = "UserCustomMapping",
//    entities = @EntityResult(
//        entityClass = User.class,
//        fields = {
//            @FieldResult(name="userId", column="id"),
//            @FieldResult(name="username", column="account"),
//            @FieldResult(name="password", column="password"),
//            @FieldResult(name="createdAt", column="created_at"),
//            @FieldResult(name="modifiedAt", column="modified_at")
//        }
//    )
//)

//@NamedNativeQuery(
//    name = "FindUserWithDetailInfoById",
//    query = """
//        SELECT
//            u.user_id, u.username, u.password, u.created_at, u.modified_at,
//            ud.user_detail_id, ud.first_name, ud.last_name, ud.gender, ud.bod, ud.mobile, ud.email, ud.user_id as fk_user_id
//        FROM [user] u
//        JOIN user_detail ud
//            on u.user_id = ud.user_id
//    """,
//    resultSetMapping = "UserWithDetailInfo"
//)
//@SqlResultSetMapping(
//    name = "UserWithDetailInfo",
//    entities = {
//        @EntityResult(
//            entityClass = User.class,
//            fields = {
//                @FieldResult(name="userId", column="user_id"),
//                @FieldResult(name="username", column="username"),
//                @FieldResult(name="password", column="password"),
//                @FieldResult(name="createdAt", column="created_at"),
//                @FieldResult(name="modifiedAt", column="modified_at")
//            }
//        ),
//        @EntityResult(
//            entityClass = UserDetail.class,
//            fields = {
//                @FieldResult(name="userDetailId", column="user_detail_id"),
//                @FieldResult(name="firstName", column="first_name"),
//                @FieldResult(name="lastName", column="last_name"),
//                @FieldResult(name="gender", column="gender"),
//                @FieldResult(name="bod", column="bod"),
//                @FieldResult(name="mobile", column="mobile"),
//                @FieldResult(name="email", column="email"),
//                @FieldResult(name="user", column="fk_user_id")
//            }
//        )
//    }
//)
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
