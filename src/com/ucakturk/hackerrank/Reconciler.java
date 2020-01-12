package com.ucakturk.hackerrank;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reconciler {

    Stream<PendingTransaction> reconcile(Stream<PendingTransaction> pending,
        Stream<Stream<ProcessedTransaction>> processed) {
        if (pending == null) {
            return Stream.empty();
        } else if (processed == null || Stream.empty().equals(processed)) {
            return pending;
        }
        List<Long> filteredProcessedId = processed.flatMap(p -> p)
            .filter(Objects::nonNull)
            .filter(p -> p.getId() != null && p.getId().length() > 0)
            .filter(p -> p.getStatus() != null && "DONE".equals(p.getStatus().orElse("").toUpperCase()))
            .map(p -> Long.parseLong(p.getId()))
            .collect(Collectors.toList());

        return pending.filter(p -> filteredProcessedId.contains(p.getId()));
    }

    public static void main(String[] args) {
        //test-1
        Reconciler reconciler = new Reconciler();
        PendingTransaction pendingTransaction = new PendingTransaction();
        pendingTransaction.setId(2L);
        PendingTransaction pendingTransaction2 = new PendingTransaction();
        pendingTransaction2.setId(3L);
        ProcessedTransaction processedTransaction = new ProcessedTransaction();
        processedTransaction.setId("1");
        ProcessedTransaction processedTransaction2 = new ProcessedTransaction();
        processedTransaction2.setId("2");
        processedTransaction2.setStatus(Optional.of("DONE"));
        ProcessedTransaction processedTransaction3 = new ProcessedTransaction();
        processedTransaction3.setId("3");
        processedTransaction3.setStatus(Optional.of("DONE"));
        Stream<PendingTransaction> pendingTransactionStream = Stream.of(pendingTransaction, pendingTransaction2);
        Stream<Stream<ProcessedTransaction>> processedTransactionStream =
            Stream.of(Stream.of(processedTransaction,processedTransaction3, processedTransaction2));
        Stream<PendingTransaction> result = reconciler.reconcile(pendingTransactionStream, processedTransactionStream);
        System.out.println(result.count());
    }
}
