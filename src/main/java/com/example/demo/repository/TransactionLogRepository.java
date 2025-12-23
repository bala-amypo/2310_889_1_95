import com.example.demo.repository.TransactionLogRepository;

private final TransactionLogRepository repository;

public TransactionController(TransactionLogRepository repository) {
    this.repository = repository;
}
