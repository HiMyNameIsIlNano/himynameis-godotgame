package com.example.demo.protobuf;

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
    value = "by gRPC proto compiler (version 1.32.1)",
    comments = "Source: planetGrpcService.proto")
public final class PlanetGrpcServiceGrpc {

  private PlanetGrpcServiceGrpc() {}

  public static final String SERVICE_NAME = "PlanetGrpcService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.example.demo.protobuf.PlanetProto.PlanetResearchResponse> getFindAllMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FindAll",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.example.demo.protobuf.PlanetProto.PlanetResearchResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.example.demo.protobuf.PlanetProto.PlanetResearchResponse> getFindAllMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.example.demo.protobuf.PlanetProto.PlanetResearchResponse> getFindAllMethod;
    if ((getFindAllMethod = PlanetGrpcServiceGrpc.getFindAllMethod) == null) {
      synchronized (PlanetGrpcServiceGrpc.class) {
        if ((getFindAllMethod = PlanetGrpcServiceGrpc.getFindAllMethod) == null) {
          PlanetGrpcServiceGrpc.getFindAllMethod = getFindAllMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.example.demo.protobuf.PlanetProto.PlanetResearchResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FindAll"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.demo.protobuf.PlanetProto.PlanetResearchResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PlanetGrpcServiceMethodDescriptorSupplier("FindAll"))
              .build();
        }
      }
    }
    return getFindAllMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.demo.protobuf.PlanetProto.PlanetInitRequest,
      com.google.protobuf.Empty> getInitMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Init",
      requestType = com.example.demo.protobuf.PlanetProto.PlanetInitRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.demo.protobuf.PlanetProto.PlanetInitRequest,
      com.google.protobuf.Empty> getInitMethod() {
    io.grpc.MethodDescriptor<com.example.demo.protobuf.PlanetProto.PlanetInitRequest, com.google.protobuf.Empty> getInitMethod;
    if ((getInitMethod = PlanetGrpcServiceGrpc.getInitMethod) == null) {
      synchronized (PlanetGrpcServiceGrpc.class) {
        if ((getInitMethod = PlanetGrpcServiceGrpc.getInitMethod) == null) {
          PlanetGrpcServiceGrpc.getInitMethod = getInitMethod =
              io.grpc.MethodDescriptor.<com.example.demo.protobuf.PlanetProto.PlanetInitRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Init"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.demo.protobuf.PlanetProto.PlanetInitRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new PlanetGrpcServiceMethodDescriptorSupplier("Init"))
              .build();
        }
      }
    }
    return getInitMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.google.protobuf.Empty> getRemoveAllPlanetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RemoveAllPlanets",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.google.protobuf.Empty> getRemoveAllPlanetsMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.google.protobuf.Empty> getRemoveAllPlanetsMethod;
    if ((getRemoveAllPlanetsMethod = PlanetGrpcServiceGrpc.getRemoveAllPlanetsMethod) == null) {
      synchronized (PlanetGrpcServiceGrpc.class) {
        if ((getRemoveAllPlanetsMethod = PlanetGrpcServiceGrpc.getRemoveAllPlanetsMethod) == null) {
          PlanetGrpcServiceGrpc.getRemoveAllPlanetsMethod = getRemoveAllPlanetsMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RemoveAllPlanets"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new PlanetGrpcServiceMethodDescriptorSupplier("RemoveAllPlanets"))
              .build();
        }
      }
    }
    return getRemoveAllPlanetsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.demo.protobuf.PlanetProto.PlanetRemoveRequest,
      com.google.protobuf.Empty> getRemovePlanetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RemovePlanet",
      requestType = com.example.demo.protobuf.PlanetProto.PlanetRemoveRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.demo.protobuf.PlanetProto.PlanetRemoveRequest,
      com.google.protobuf.Empty> getRemovePlanetMethod() {
    io.grpc.MethodDescriptor<com.example.demo.protobuf.PlanetProto.PlanetRemoveRequest, com.google.protobuf.Empty> getRemovePlanetMethod;
    if ((getRemovePlanetMethod = PlanetGrpcServiceGrpc.getRemovePlanetMethod) == null) {
      synchronized (PlanetGrpcServiceGrpc.class) {
        if ((getRemovePlanetMethod = PlanetGrpcServiceGrpc.getRemovePlanetMethod) == null) {
          PlanetGrpcServiceGrpc.getRemovePlanetMethod = getRemovePlanetMethod =
              io.grpc.MethodDescriptor.<com.example.demo.protobuf.PlanetProto.PlanetRemoveRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RemovePlanet"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.demo.protobuf.PlanetProto.PlanetRemoveRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new PlanetGrpcServiceMethodDescriptorSupplier("RemovePlanet"))
              .build();
        }
      }
    }
    return getRemovePlanetMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PlanetGrpcServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PlanetGrpcServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PlanetGrpcServiceStub>() {
        @java.lang.Override
        public PlanetGrpcServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PlanetGrpcServiceStub(channel, callOptions);
        }
      };
    return PlanetGrpcServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PlanetGrpcServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PlanetGrpcServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PlanetGrpcServiceBlockingStub>() {
        @java.lang.Override
        public PlanetGrpcServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PlanetGrpcServiceBlockingStub(channel, callOptions);
        }
      };
    return PlanetGrpcServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PlanetGrpcServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PlanetGrpcServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PlanetGrpcServiceFutureStub>() {
        @java.lang.Override
        public PlanetGrpcServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PlanetGrpcServiceFutureStub(channel, callOptions);
        }
      };
    return PlanetGrpcServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class PlanetGrpcServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void findAll(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.example.demo.protobuf.PlanetProto.PlanetResearchResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getFindAllMethod(), responseObserver);
    }

    /**
     */
    public void init(com.example.demo.protobuf.PlanetProto.PlanetInitRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getInitMethod(), responseObserver);
    }

    /**
     */
    public void removeAllPlanets(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getRemoveAllPlanetsMethod(), responseObserver);
    }

    /**
     */
    public void removePlanet(com.example.demo.protobuf.PlanetProto.PlanetRemoveRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getRemovePlanetMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getFindAllMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                com.example.demo.protobuf.PlanetProto.PlanetResearchResponse>(
                  this, METHODID_FIND_ALL)))
          .addMethod(
            getInitMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.demo.protobuf.PlanetProto.PlanetInitRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_INIT)))
          .addMethod(
            getRemoveAllPlanetsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                com.google.protobuf.Empty>(
                  this, METHODID_REMOVE_ALL_PLANETS)))
          .addMethod(
            getRemovePlanetMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.demo.protobuf.PlanetProto.PlanetRemoveRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_REMOVE_PLANET)))
          .build();
    }
  }

  /**
   */
  public static final class PlanetGrpcServiceStub extends io.grpc.stub.AbstractAsyncStub<PlanetGrpcServiceStub> {
    private PlanetGrpcServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PlanetGrpcServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PlanetGrpcServiceStub(channel, callOptions);
    }

    /**
     */
    public void findAll(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.example.demo.protobuf.PlanetProto.PlanetResearchResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getFindAllMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void init(com.example.demo.protobuf.PlanetProto.PlanetInitRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInitMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void removeAllPlanets(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRemoveAllPlanetsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void removePlanet(com.example.demo.protobuf.PlanetProto.PlanetRemoveRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRemovePlanetMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class PlanetGrpcServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<PlanetGrpcServiceBlockingStub> {
    private PlanetGrpcServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PlanetGrpcServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PlanetGrpcServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.demo.protobuf.PlanetProto.PlanetResearchResponse findAll(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), getFindAllMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty init(com.example.demo.protobuf.PlanetProto.PlanetInitRequest request) {
      return blockingUnaryCall(
          getChannel(), getInitMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty removeAllPlanets(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), getRemoveAllPlanetsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty removePlanet(com.example.demo.protobuf.PlanetProto.PlanetRemoveRequest request) {
      return blockingUnaryCall(
          getChannel(), getRemovePlanetMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PlanetGrpcServiceFutureStub extends io.grpc.stub.AbstractFutureStub<PlanetGrpcServiceFutureStub> {
    private PlanetGrpcServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PlanetGrpcServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PlanetGrpcServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.demo.protobuf.PlanetProto.PlanetResearchResponse> findAll(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getFindAllMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> init(
        com.example.demo.protobuf.PlanetProto.PlanetInitRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getInitMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> removeAllPlanets(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getRemoveAllPlanetsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> removePlanet(
        com.example.demo.protobuf.PlanetProto.PlanetRemoveRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRemovePlanetMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FIND_ALL = 0;
  private static final int METHODID_INIT = 1;
  private static final int METHODID_REMOVE_ALL_PLANETS = 2;
  private static final int METHODID_REMOVE_PLANET = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PlanetGrpcServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PlanetGrpcServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FIND_ALL:
          serviceImpl.findAll((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.example.demo.protobuf.PlanetProto.PlanetResearchResponse>) responseObserver);
          break;
        case METHODID_INIT:
          serviceImpl.init((com.example.demo.protobuf.PlanetProto.PlanetInitRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_REMOVE_ALL_PLANETS:
          serviceImpl.removeAllPlanets((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_REMOVE_PLANET:
          serviceImpl.removePlanet((com.example.demo.protobuf.PlanetProto.PlanetRemoveRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
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

  private static abstract class PlanetGrpcServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PlanetGrpcServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.demo.protobuf.PlanetServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PlanetGrpcService");
    }
  }

  private static final class PlanetGrpcServiceFileDescriptorSupplier
      extends PlanetGrpcServiceBaseDescriptorSupplier {
    PlanetGrpcServiceFileDescriptorSupplier() {}
  }

  private static final class PlanetGrpcServiceMethodDescriptorSupplier
      extends PlanetGrpcServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PlanetGrpcServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (PlanetGrpcServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PlanetGrpcServiceFileDescriptorSupplier())
              .addMethod(getFindAllMethod())
              .addMethod(getInitMethod())
              .addMethod(getRemoveAllPlanetsMethod())
              .addMethod(getRemovePlanetMethod())
              .build();
        }
      }
    }
    return result;
  }
}
