package ru.krista.uniyar;

import io.grpc.stub.StreamObserver;
import io.quarkus.calc.CalculatorProto;

import javax.inject.Singleton;
import java.math.BigDecimal;

import static io.quarkus.calc.CalculatorProto.CalculatorRequest.OperationType.*;

@Singleton
public class CalculatorService extends io.quarkus.calc.CalculatorServiceGrpc.CalculatorServiceImplBase{

    @Override
    public void calculate(CalculatorProto.CalculatorRequest request, StreamObserver<CalculatorProto.CalculatorResponse> responseObserver) {
        BigDecimal number1 = BigDecimal.valueOf(request.getNumber1());
        BigDecimal number2 = BigDecimal.valueOf(request.getNumber2());
        String status = "";
        CalculatorProto.CalculatorRequest.OperationType operationType = request.getOperation();
        switch (operationType) {
            case ADD:
                number1 = number1.add(number2);
                status = "Успех";
                break;
            case MULTIPLY:
                number1 = number1.multiply(number2);
                status = "Успех";
                break;
            case DIVIDE:
                try {
                    number1 = number1.divide(number2);
                    status = "Успех";
                } catch (ArithmeticException ex) {
                     status = ex.getMessage();
                }
                break;
            case SUBTRACT:
                number1 = number1.subtract(number2);
                status = "Успех";
                break;
            default:

        }
        responseObserver.onNext(CalculatorProto.CalculatorResponse.newBuilder().setResult(number1.doubleValue()).setStatus(status).build());
        responseObserver.onCompleted();
    }
}
