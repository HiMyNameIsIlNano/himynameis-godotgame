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
    comments = "Source: rewardGrpcService.proto")
public final class RewardServiceGrpc {

  private RewardServiceGrpc() {}

  public static final String SERVICE_NAME = "RewardService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.demo.protobuf.RewardProto.RewardRequest,
      com.example.demo.protobuf.RewardProto.RewardResponse> getGetRewardsOnGoalMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRewardsOnGoal",
      requestType = com.example.demo.protobuf.RewardProto.RewardRequest.class,
      responseType = com.example.demo.protobuf.RewardProto.RewardResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.demo.protobuf.RewardProto.RewardRequest,
      com.example.demo.protobuf.RewardProto.RewardResponse> getGetRewardsOnGoalMethod() {
    io.grpc.MethodDescriptor<com.example.demo.protobuf.RewardProto.RewardRequest, com.example.demo.protobuf.RewardProto.RewardResponse> getGetRewardsOnGoalMethod;
    if ((getGetRewardsOnGoalMethod = RewardServiceGrpc.getGetRewardsOnGoalMethod) == null) {
      synchronized (RewardServiceGrpc.class) {
        if ((getGetRewardsOnGoalMethod = RewardServiceGrpc.getGetRewardsOnGoalMethod) == null) {
          RewardServiceGrpc.getGetRewardsOnGoalMethod = getGetRewardsOnGoalMethod =
              io.grpc.MethodDescriptor.<com.example.demo.protobuf.RewardProto.RewardRequest, com.example.demo.protobuf.RewardProto.RewardResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRewardsOnGoal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.demo.protobuf.RewardProto.RewardRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.demo.protobuf.RewardProto.RewardResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RewardServiceMethodDescriptorSupplier("GetRewardsOnGoal"))
              .build();
        }
      }
    }
    return getGetRewardsOnGoalMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.demo.protobuf.RewardProto.RewardRequest,
      com.example.demo.protobuf.RewardProto.RewardResponse> getGetRewardsOnLevelClearedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRewardsOnLevelCleared",
      requestType = com.example.demo.protobuf.RewardProto.RewardRequest.class,
      responseType = com.example.demo.protobuf.RewardProto.RewardResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.demo.protobuf.RewardProto.RewardRequest,
      com.example.demo.protobuf.RewardProto.RewardResponse> getGetRewardsOnLevelClearedMethod() {
    io.grpc.MethodDescriptor<com.example.demo.protobuf.RewardProto.RewardRequest, com.example.demo.protobuf.RewardProto.RewardResponse> getGetRewardsOnLevelClearedMethod;
    if ((getGetRewardsOnLevelClearedMethod = RewardServiceGrpc.getGetRewardsOnLevelClearedMethod) == null) {
      synchronized (RewardServiceGrpc.class) {
        if ((getGetRewardsOnLevelClearedMethod = RewardServiceGrpc.getGetRewardsOnLevelClearedMethod) == null) {
          RewardServiceGrpc.getGetRewardsOnLevelClearedMethod = getGetRewardsOnLevelClearedMethod =
              io.grpc.MethodDescriptor.<com.example.demo.protobuf.RewardProto.RewardRequest, com.example.demo.protobuf.RewardProto.RewardResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRewardsOnLevelCleared"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.demo.protobuf.RewardProto.RewardRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.demo.protobuf.RewardProto.RewardResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RewardServiceMethodDescriptorSupplier("GetRewardsOnLevelCleared"))
              .build();
        }
      }
    }
    return getGetRewardsOnLevelClearedMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RewardServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RewardServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RewardServiceStub>() {
        @java.lang.Override
        public RewardServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RewardServiceStub(channel, callOptions);
        }
      };
    return RewardServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RewardServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RewardServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RewardServiceBlockingStub>() {
        @java.lang.Override
        public RewardServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RewardServiceBlockingStub(channel, callOptions);
        }
      };
    return RewardServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RewardServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RewardServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RewardServiceFutureStub>() {
        @java.lang.Override
        public RewardServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RewardServiceFutureStub(channel, callOptions);
        }
      };
    return RewardServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class RewardServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getRewardsOnGoal(com.example.demo.protobuf.RewardProto.RewardRequest request,
        io.grpc.stub.StreamObserver<com.example.demo.protobuf.RewardProto.RewardResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetRewardsOnGoalMethod(), responseObserver);
    }

    /**
     */
    public void getRewardsOnLevelCleared(com.example.demo.protobuf.RewardProto.RewardRequest request,
        io.grpc.stub.StreamObserver<com.example.demo.protobuf.RewardProto.RewardResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetRewardsOnLevelClearedMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetRewardsOnGoalMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.demo.protobuf.RewardProto.RewardRequest,
                com.example.demo.protobuf.RewardProto.RewardResponse>(
                  this, METHODID_GET_REWARDS_ON_GOAL)))
          .addMethod(
            getGetRewardsOnLevelClearedMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.demo.protobuf.RewardProto.RewardRequest,
                com.example.demo.protobuf.RewardProto.RewardResponse>(
                  this, METHODID_GET_REWARDS_ON_LEVEL_CLEARED)))
          .build();
    }
  }

  /**
   */
  public static final class RewardServiceStub extends io.grpc.stub.AbstractAsyncStub<RewardServiceStub> {
    private RewardServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RewardServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RewardServiceStub(channel, callOptions);
    }

    /**
     */
    public void getRewardsOnGoal(com.example.demo.protobuf.RewardProto.RewardRequest request,
        io.grpc.stub.StreamObserver<com.example.demo.protobuf.RewardProto.RewardResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetRewardsOnGoalMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getRewardsOnLevelCleared(com.example.demo.protobuf.RewardProto.RewardRequest request,
        io.grpc.stub.StreamObserver<com.example.demo.protobuf.RewardProto.RewardResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetRewardsOnLevelClearedMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RewardServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<RewardServiceBlockingStub> {
    private RewardServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RewardServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RewardServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.demo.protobuf.RewardProto.RewardResponse getRewardsOnGoal(com.example.demo.protobuf.RewardProto.RewardRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetRewardsOnGoalMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.demo.protobuf.RewardProto.RewardResponse getRewardsOnLevelCleared(com.example.demo.protobuf.RewardProto.RewardRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetRewardsOnLevelClearedMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RewardServiceFutureStub extends io.grpc.stub.AbstractFutureStub<RewardServiceFutureStub> {
    private RewardServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RewardServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RewardServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.demo.protobuf.RewardProto.RewardResponse> getRewardsOnGoal(
        com.example.demo.protobuf.RewardProto.RewardRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetRewardsOnGoalMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.demo.protobuf.RewardProto.RewardResponse> getRewardsOnLevelCleared(
        com.example.demo.protobuf.RewardProto.RewardRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetRewardsOnLevelClearedMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_REWARDS_ON_GOAL = 0;
  private static final int METHODID_GET_REWARDS_ON_LEVEL_CLEARED = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RewardServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RewardServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_REWARDS_ON_GOAL:
          serviceImpl.getRewardsOnGoal((com.example.demo.protobuf.RewardProto.RewardRequest) request,
              (io.grpc.stub.StreamObserver<com.example.demo.protobuf.RewardProto.RewardResponse>) responseObserver);
          break;
        case METHODID_GET_REWARDS_ON_LEVEL_CLEARED:
          serviceImpl.getRewardsOnLevelCleared((com.example.demo.protobuf.RewardProto.RewardRequest) request,
              (io.grpc.stub.StreamObserver<com.example.demo.protobuf.RewardProto.RewardResponse>) responseObserver);
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

  private static abstract class RewardServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RewardServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.demo.protobuf.RewardServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RewardService");
    }
  }

  private static final class RewardServiceFileDescriptorSupplier
      extends RewardServiceBaseDescriptorSupplier {
    RewardServiceFileDescriptorSupplier() {}
  }

  private static final class RewardServiceMethodDescriptorSupplier
      extends RewardServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RewardServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (RewardServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RewardServiceFileDescriptorSupplier())
              .addMethod(getGetRewardsOnGoalMethod())
              .addMethod(getGetRewardsOnLevelClearedMethod())
              .build();
        }
      }
    }
    return result;
  }
}
