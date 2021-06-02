package hrms.hrms.entities.concretes;

import java.util.Date;

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
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "education_details")
public class EducationDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotNull
	@NotBlank
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "end_date")
	private Date endDate;
	
	@NotBlank
	@NotNull
	@Column(name = "is_graduated", columnDefinition = "boolean default false")
	private boolean isGraduated = false;
	
	@NotBlank
	@NotNull
	@OneToOne(optional = true)
	@JoinColumn(name = "user_id")
	private User user;
	
	@NotNull
	@NotBlank
	@OneToOne(optional = true)
	@JoinColumn(name = "school_id")
	private School school;
	
}
