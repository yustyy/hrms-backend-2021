package hrms.hrms.core.adapters.validation.concretes;


import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.stereotype.Service;

import hrms.hrms.core.adapters.validation.abstracts.UserVerificationService;
import hrms.hrms.entities.concretes.JobSeeker;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;


@Service
public class MernisServiceAdapter implements UserVerificationService {

	@Override
	public boolean validateJobSeeker(JobSeeker jobSeeker) {
		
		KPSPublicSoapProxy proxy = new KPSPublicSoapProxy();
		
		try {		
			
			LocalDate localDate = jobSeeker.getBirthDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			
			
			return proxy.TCKimlikNoDogrula(Long.parseLong(jobSeeker.getNationalIdentity()),
					jobSeeker.getFirstName().toUpperCase(),
					jobSeeker.getLastName().toUpperCase(), 
					localDate.getYear());
			
			
			
		} catch (NumberFormatException | RemoteException e) {

			e.printStackTrace();
			return false;
		}
		
	}

}
