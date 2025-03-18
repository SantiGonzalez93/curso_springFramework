package santi.sprigboot_course.jpa_relationships;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import santi.sprigboot_course.jpa_relationships.entity.Address;
import santi.sprigboot_course.jpa_relationships.entity.Client;
import santi.sprigboot_course.jpa_relationships.entity.Invoice;
import santi.sprigboot_course.jpa_relationships.repository.ClienteRepository;
import santi.sprigboot_course.jpa_relationships.repository.InvoiceRepository;

@SpringBootApplication
public class JpaRelationshipsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JpaRelationshipsApplication.class, args);
	}

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private InvoiceRepository invoiceRepository;
	@Override
	public void run(String... args) throws Exception {

		oneToMany();
	}

	@Transactional
	public void oneToMany() {
		Client client = new Client("Santi", "González");
		Address address1 = new Address("El vejal", 1234);
		Address address2 = new Address("Gutierrrez", 495);
		client.getAddreses().add(address1);
		client.getAddreses().add(address2);
		System.out.println(clienteRepository.save(client));
	}
	@Transactional
	public void manyToOne(){
		Client client = new Client("Santi", "Gonzalez");
		clienteRepository.save(client);

		Invoice newInvoice = new Invoice("Compras de oficina", 2000L, client);
		System.out.println(invoiceRepository.save(newInvoice));
	}

	@Transactional
	public void manyToOneFindById(){
		Client client = clienteRepository.findById(1L).orElse(null);

		Invoice newInvoice = new Invoice("Compras de limpieza", 10L, client);
		System.out.println(invoiceRepository.save(newInvoice));
	}
}
