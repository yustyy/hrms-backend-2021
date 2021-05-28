package hrms.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "company_staff_verifications")
public class CompanyStaffVerification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotBlank
	@Column(name = "is_approved")
	private boolean isApproved;
	
	@NotBlank
	@OneToOne(optional = true)
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToOne(optional = true)
	@JoinColumn(name = "authorized_company_staff_id")
	private CompanyStaff companyStaff;
}
