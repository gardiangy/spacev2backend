package hu.voga.space.entity;




import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "user")
public class User {

  @Id
  @GeneratedValue(generator="system-uuid")
  @GenericGenerator(name="system-uuid", strategy = "uuid")
  @Column(name = "user_guid")
  private String userGuid;

  @Column(name = "user_name")
  private String userName;

  @Column(name = "user_email")
  private String userEmail;

  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
  private List<SolarSystem> solarSystems;

  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
  private List<Discovered> discovered;


}
