package hrms.hrms.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_experiences")
public class JobExperience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotNull
	@OneToOne(optional = true)
	@JoinColumn(name = "user_id")
	private User user;
	
	@NotBlank
	@NotNull
	@Column(name = "workplace_name")
	private String worplaceName;
	
	@NotNull
	@OneToOne(optional = true)
	@JoinColumn(name = "job_position_id")
	private JobPosition jobPosition;
	
	@NotNull
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "leave_date")
	private Date leaveDate;
	
	@NotNull
	@Column(name = "is_active", columnDefinition = "boolean default false")
	private boolean isActive = false;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "jobExperiences")
	private List<Cv> cv;
	
	
	

}
