package ru.krista.uniyar;

import io.quarkus.calc.CalculatorProto;
import io.quarkus.grpc.runtime.annotations.GrpcService;
import org.mvel2.ast.DoUntilNode;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/calculator")
public class CalculatorResource {

    @Inject
    @GrpcService("calculator")
    io.quarkus.calc.CalculatorServiceGrpc.CalculatorServiceBlockingStub client;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String calculator() {
        return "calculator";
    }

    @GET
    @Path("add/{number1}/{number2}")
    public String add(@PathParam("number1") Double number1, @PathParam("number2") Double number2) {
        CalculatorProto.CalculatorRequest request = CalculatorProto.CalculatorRequest.newBuilder().setNumber1(number1).setNumber2(number2).setOperation(CalculatorProto.CalculatorRequest.OperationType.ADD).build();
        String status = client.calculate(request).getStatus();
        return status.equals("Успех") ? String.valueOf(client.calculate(request).getResult()) : status;
    }

    @GET
    @Path("subtract/{number1}/{number2}")
    public String subtract(@PathParam("number1") Double number1, @PathParam("number2") Double number2) {
        CalculatorProto.CalculatorRequest request = CalculatorProto.CalculatorRequest.newBuilder().setNumber1(number1).setNumber2(number2).setOperation(CalculatorProto.CalculatorRequest.OperationType.SUBTRACT).build();
        String status = client.calculate(request).getStatus();
        return status.equals("Успех") ? String.valueOf(client.calculate(request).getResult()) : status;
    }

    @GET
    @Path("multiply/{number1}/{number2}")
    public String multiply(@PathParam("number1") Double number1, @PathParam("number2") Double number2) {
        CalculatorProto.CalculatorRequest request = CalculatorProto.CalculatorRequest.newBuilder().setNumber1(number1).setNumber2(number2).setOperation(CalculatorProto.CalculatorRequest.OperationType.MULTIPLY).build();
        String status = client.calculate(request).getStatus();
        return status.equals("Успех") ? String.valueOf(client.calculate(request).getResult()) : status;
    }

    @GET
    @Path("divide/{number1}/{number2}")
    public String divide(@PathParam("number1") Double number1, @PathParam("number2") Double number2) {
        CalculatorProto.CalculatorRequest request = CalculatorProto.CalculatorRequest.newBuilder().setNumber1(number1).setNumber2(number2).setOperation(CalculatorProto.CalculatorRequest.OperationType.DIVIDE).build();
        String status = client.calculate(request).getStatus();
        return status.equals("Успех") ? String.valueOf(client.calculate(request).getResult()) : status;
    }

}
