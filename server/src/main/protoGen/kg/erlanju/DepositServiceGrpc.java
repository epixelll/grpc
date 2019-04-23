package kg.erlanju;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.20.0)",
    comments = "Source: HelloService.proto")
public final class DepositServiceGrpc {

  private DepositServiceGrpc() {}

  public static final String SERVICE_NAME = "kg.erlanju.DepositService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<kg.erlanju.DepositRequest,
      kg.erlanju.HelloResponse> getDepositMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deposit",
      requestType = kg.erlanju.DepositRequest.class,
      responseType = kg.erlanju.HelloResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<kg.erlanju.DepositRequest,
      kg.erlanju.HelloResponse> getDepositMethod() {
    io.grpc.MethodDescriptor<kg.erlanju.DepositRequest, kg.erlanju.HelloResponse> getDepositMethod;
    if ((getDepositMethod = DepositServiceGrpc.getDepositMethod) == null) {
      synchronized (DepositServiceGrpc.class) {
        if ((getDepositMethod = DepositServiceGrpc.getDepositMethod) == null) {
          DepositServiceGrpc.getDepositMethod = getDepositMethod = 
              io.grpc.MethodDescriptor.<kg.erlanju.DepositRequest, kg.erlanju.HelloResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "kg.erlanju.DepositService", "deposit"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  kg.erlanju.DepositRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  kg.erlanju.HelloResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new DepositServiceMethodDescriptorSupplier("deposit"))
                  .build();
          }
        }
     }
     return getDepositMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DepositServiceStub newStub(io.grpc.Channel channel) {
    return new DepositServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DepositServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new DepositServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DepositServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new DepositServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class DepositServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void deposit(kg.erlanju.DepositRequest request,
        io.grpc.stub.StreamObserver<kg.erlanju.HelloResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDepositMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getDepositMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                kg.erlanju.DepositRequest,
                kg.erlanju.HelloResponse>(
                  this, METHODID_DEPOSIT)))
          .build();
    }
  }

  /**
   */
  public static final class DepositServiceStub extends io.grpc.stub.AbstractStub<DepositServiceStub> {
    private DepositServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DepositServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DepositServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DepositServiceStub(channel, callOptions);
    }

    /**
     */
    public void deposit(kg.erlanju.DepositRequest request,
        io.grpc.stub.StreamObserver<kg.erlanju.HelloResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDepositMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DepositServiceBlockingStub extends io.grpc.stub.AbstractStub<DepositServiceBlockingStub> {
    private DepositServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DepositServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DepositServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DepositServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public kg.erlanju.HelloResponse deposit(kg.erlanju.DepositRequest request) {
      return blockingUnaryCall(
          getChannel(), getDepositMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DepositServiceFutureStub extends io.grpc.stub.AbstractStub<DepositServiceFutureStub> {
    private DepositServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DepositServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DepositServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DepositServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<kg.erlanju.HelloResponse> deposit(
        kg.erlanju.DepositRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDepositMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_DEPOSIT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DepositServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DepositServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DEPOSIT:
          serviceImpl.deposit((kg.erlanju.DepositRequest) request,
              (io.grpc.stub.StreamObserver<kg.erlanju.HelloResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class DepositServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DepositServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return kg.erlanju.HelloService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DepositService");
    }
  }

  private static final class DepositServiceFileDescriptorSupplier
      extends DepositServiceBaseDescriptorSupplier {
    DepositServiceFileDescriptorSupplier() {}
  }

  private static final class DepositServiceMethodDescriptorSupplier
      extends DepositServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DepositServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (DepositServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DepositServiceFileDescriptorSupplier())
              .addMethod(getDepositMethod())
              .build();
        }
      }
    }
    return result;
  }
}
