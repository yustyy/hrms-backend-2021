package hrms.hrms.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "company_staff_verifications")
public class CompanyStaffVerification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotNull
	@NotBlank
	@OneToOne(optional = true)
	@JoinColumn(name = "user_id")
	private User user;
	
	@NotBlank
	@OneToOne(optional = true)
	@JoinColumn(name = "authorized_company_staff_id")
	private CompanyStaff companyStaff;
	
	@NotNull
	@NotBlank
	@Column(name = "is_approved", columnDefinition = "boolean default false")
	private boolean isApproved = false;
	
	@NotBlank
	@NotNull
	@Column(name = "created_at", columnDefinition = "Date default CURRENT_DATE")
	private LocalDateTime createdAt = LocalDateTime.now();
	
	@NotBlank
	@Column(name = "approval_date")
	private LocalDateTime approvalDate;
	
	
	@Builder
	public CompanyStaffVerification(User user) {
		this.user = user;
	}
	
	
	
	
}
