package com.example.demo.protobuf;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.32.1)",
    comments = "Source: socketGrpcService.proto")
public final class SocketServerGrpcServiceGrpc {

  private SocketServerGrpcServiceGrpc() {}

  public static final String SERVICE_NAME = "SocketServerGrpcService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.example.demo.protobuf.SocketPush.SocketConnectionResponse> getConnectToServerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ConnectToServer",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.example.demo.protobuf.SocketPush.SocketConnectionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.example.demo.protobuf.SocketPush.SocketConnectionResponse> getConnectToServerMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.example.demo.protobuf.SocketPush.SocketConnectionResponse> getConnectToServerMethod;
    if ((getConnectToServerMethod = SocketServerGrpcServiceGrpc.getConnectToServerMethod) == null) {
      synchronized (SocketServerGrpcServiceGrpc.class) {
        if ((getConnectToServerMethod = SocketServerGrpcServiceGrpc.getConnectToServerMethod) == null) {
          SocketServerGrpcServiceGrpc.getConnectToServerMethod = getConnectToServerMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.example.demo.protobuf.SocketPush.SocketConnectionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ConnectToServer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.demo.protobuf.SocketPush.SocketConnectionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SocketServerGrpcServiceMethodDescriptorSupplier("ConnectToServer"))
              .build();
        }
      }
    }
    return getConnectToServerMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SocketServerGrpcServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SocketServerGrpcServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SocketServerGrpcServiceStub>() {
        @java.lang.Override
        public SocketServerGrpcServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SocketServerGrpcServiceStub(channel, callOptions);
        }
      };
    return SocketServerGrpcServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SocketServerGrpcServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SocketServerGrpcServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SocketServerGrpcServiceBlockingStub>() {
        @java.lang.Override
        public SocketServerGrpcServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SocketServerGrpcServiceBlockingStub(channel, callOptions);
        }
      };
    return SocketServerGrpcServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SocketServerGrpcServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SocketServerGrpcServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SocketServerGrpcServiceFutureStub>() {
        @java.lang.Override
        public SocketServerGrpcServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SocketServerGrpcServiceFutureStub(channel, callOptions);
        }
      };
    return SocketServerGrpcServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class SocketServerGrpcServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void connectToServer(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.example.demo.protobuf.SocketPush.SocketConnectionResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getConnectToServerMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getConnectToServerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                com.example.demo.protobuf.SocketPush.SocketConnectionResponse>(
                  this, METHODID_CONNECT_TO_SERVER)))
          .build();
    }
  }

  /**
   */
  public static final class SocketServerGrpcServiceStub extends io.grpc.stub.AbstractAsyncStub<SocketServerGrpcServiceStub> {
    private SocketServerGrpcServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SocketServerGrpcServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SocketServerGrpcServiceStub(channel, callOptions);
    }

    /**
     */
    public void connectToServer(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.example.demo.protobuf.SocketPush.SocketConnectionResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getConnectToServerMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SocketServerGrpcServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<SocketServerGrpcServiceBlockingStub> {
    private SocketServerGrpcServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SocketServerGrpcServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SocketServerGrpcServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.demo.protobuf.SocketPush.SocketConnectionResponse connectToServer(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), getConnectToServerMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SocketServerGrpcServiceFutureStub extends io.grpc.stub.AbstractFutureStub<SocketServerGrpcServiceFutureStub> {
    private SocketServerGrpcServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SocketServerGrpcServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SocketServerGrpcServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.demo.protobuf.SocketPush.SocketConnectionResponse> connectToServer(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getConnectToServerMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CONNECT_TO_SERVER = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SocketServerGrpcServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SocketServerGrpcServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CONNECT_TO_SERVER:
          serviceImpl.connectToServer((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.example.demo.protobuf.SocketPush.SocketConnectionResponse>) responseObserver);
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

  private static abstract class SocketServerGrpcServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SocketServerGrpcServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.demo.protobuf.SocketServerHandlerProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SocketServerGrpcService");
    }
  }

  private static final class SocketServerGrpcServiceFileDescriptorSupplier
      extends SocketServerGrpcServiceBaseDescriptorSupplier {
    SocketServerGrpcServiceFileDescriptorSupplier() {}
  }

  private static final class SocketServerGrpcServiceMethodDescriptorSupplier
      extends SocketServerGrpcServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SocketServerGrpcServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (SocketServerGrpcServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SocketServerGrpcServiceFileDescriptorSupplier())
              .addMethod(getConnectToServerMethod())
              .build();
        }
      }
    }
    return result;
  }
}
