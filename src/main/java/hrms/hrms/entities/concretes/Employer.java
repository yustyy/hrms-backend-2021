package hrms.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@PrimaryKeyJoinColumn(name = "user_id")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "employers")
public class Employer extends User {

	@NotBlank
	@Size(max = 100)
	@Column(name = "company_name")
	private String companyName;
	
	@NotBlank
	@Size(max = 100)
	@Column(name = "website")
	private String website;
	
	@NotBlank
	@Size(max = 16)
	@Column(name = "phone")
	private String phone;
}
