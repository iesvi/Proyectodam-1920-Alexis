package OrganizeIt;

import OrganizeIt.alerta.model.Activity;
import OrganizeIt.alerta.repository.ActiviyRepository;
import OrganizeIt.alerta.service.EmailService;
import OrganizeIt.alerta.service.impl.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@EnableDiscoveryClient
@EnableScheduling
@SpringBootApplication
public class Application {

	@Autowired
	ActiviyRepository activiyRepository;

	@Autowired
	EmailService emailService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Scheduled(cron = "0 0 0 * * ?")
	public void checkActivityDates(){

		LocalDate d = LocalDate.now();
		d.plusDays(1);
		Date dt = Date.from(d.atStartOfDay(ZoneId.systemDefault()).toInstant());

		List<Activity> activities =  activiyRepository.findAll();
		for (Activity a : activities) {
			if (!a.isFinalizada() &&  a.getFechaLimite().before(dt)){
				String[] contacts = a.getUsuarios().stream()
						.toArray(String[]::new);

				SimpleMailMessage message = new SimpleMailMessage();
				message.setTo(contacts);
				message.setSubject("Actividad "+ a.getTitulo()+" Concretada");
				message.setText("La actividad "+a.getTitulo()+" ha alcanzado la fécha límite, accede a Organize-It " +
						"para ver los detalles sobre esta actividad.");

				emailService.send(message);
			}

			a.setFinalizada(true);
			activiyRepository.save(a);
		}

	}

}
