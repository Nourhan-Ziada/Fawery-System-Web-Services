package com.fci.advanced.se.personsmanagement.TransactionDatabase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
@RestController
@RequestMapping("/TransactionDatabaseController")
public class TransactionDatabaseController {
    @GetMapping("/show")
    public  Map<String, Vector<StructTransaction>>  showTransactionDatabase()
    {
        Map<String, Vector<StructTransaction>> transactionDatabase = new HashMap<>();
        for (Map.Entry<String, Vector<StructTransaction>> entry : TransactionDatabase.getTransactionDatabase().entrySet()) {
            transactionDatabase.put(entry.getKey(),entry.getValue());
        }
        return transactionDatabase;
    }
}
