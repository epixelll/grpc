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
    comments = "Source: WithdrawService.proto")
public final class WithdrawServiceGrpc {

  private WithdrawServiceGrpc() {}

  public static final String SERVICE_NAME = "kg.erlanju.WithdrawService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<kg.erlanju.WithdrawRequest,
      kg.erlanju.WithdrawResponse> getWithdrawMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "withdraw",
      requestType = kg.erlanju.WithdrawRequest.class,
      responseType = kg.erlanju.WithdrawResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<kg.erlanju.WithdrawRequest,
      kg.erlanju.WithdrawResponse> getWithdrawMethod() {
    io.grpc.MethodDescriptor<kg.erlanju.WithdrawRequest, kg.erlanju.WithdrawResponse> getWithdrawMethod;
    if ((getWithdrawMethod = WithdrawServiceGrpc.getWithdrawMethod) == null) {
      synchronized (WithdrawServiceGrpc.class) {
        if ((getWithdrawMethod = WithdrawServiceGrpc.getWithdrawMethod) == null) {
          WithdrawServiceGrpc.getWithdrawMethod = getWithdrawMethod = 
              io.grpc.MethodDescriptor.<kg.erlanju.WithdrawRequest, kg.erlanju.WithdrawResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "kg.erlanju.WithdrawService", "withdraw"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  kg.erlanju.WithdrawRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  kg.erlanju.WithdrawResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new WithdrawServiceMethodDescriptorSupplier("withdraw"))
                  .build();
          }
        }
     }
     return getWithdrawMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WithdrawServiceStub newStub(io.grpc.Channel channel) {
    return new WithdrawServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WithdrawServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new WithdrawServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static WithdrawServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new WithdrawServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class WithdrawServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void withdraw(kg.erlanju.WithdrawRequest request,
        io.grpc.stub.StreamObserver<kg.erlanju.WithdrawResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getWithdrawMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getWithdrawMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                kg.erlanju.WithdrawRequest,
                kg.erlanju.WithdrawResponse>(
                  this, METHODID_WITHDRAW)))
          .build();
    }
  }

  /**
   */
  public static final class WithdrawServiceStub extends io.grpc.stub.AbstractStub<WithdrawServiceStub> {
    private WithdrawServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WithdrawServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WithdrawServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WithdrawServiceStub(channel, callOptions);
    }

    /**
     */
    public void withdraw(kg.erlanju.WithdrawRequest request,
        io.grpc.stub.StreamObserver<kg.erlanju.WithdrawResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWithdrawMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class WithdrawServiceBlockingStub extends io.grpc.stub.AbstractStub<WithdrawServiceBlockingStub> {
    private WithdrawServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WithdrawServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WithdrawServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WithdrawServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public kg.erlanju.WithdrawResponse withdraw(kg.erlanju.WithdrawRequest request) {
      return blockingUnaryCall(
          getChannel(), getWithdrawMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class WithdrawServiceFutureStub extends io.grpc.stub.AbstractStub<WithdrawServiceFutureStub> {
    private WithdrawServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WithdrawServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WithdrawServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WithdrawServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<kg.erlanju.WithdrawResponse> withdraw(
        kg.erlanju.WithdrawRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getWithdrawMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_WITHDRAW = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final WithdrawServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(WithdrawServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_WITHDRAW:
          serviceImpl.withdraw((kg.erlanju.WithdrawRequest) request,
              (io.grpc.stub.StreamObserver<kg.erlanju.WithdrawResponse>) responseObserver);
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

  private static abstract class WithdrawServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WithdrawServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return kg.erlanju.WithdrawServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("WithdrawService");
    }
  }

  private static final class WithdrawServiceFileDescriptorSupplier
      extends WithdrawServiceBaseDescriptorSupplier {
    WithdrawServiceFileDescriptorSupplier() {}
  }

  private static final class WithdrawServiceMethodDescriptorSupplier
      extends WithdrawServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    WithdrawServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (WithdrawServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WithdrawServiceFileDescriptorSupplier())
              .addMethod(getWithdrawMethod())
              .build();
        }
      }
    }
    return result;
  }
}
