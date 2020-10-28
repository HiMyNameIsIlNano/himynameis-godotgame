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
public final class RewardServiceGrpcGrpc {

  private RewardServiceGrpcGrpc() {}

  public static final String SERVICE_NAME = "RewardServiceGrpc";

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
    if ((getGetRewardsOnGoalMethod = RewardServiceGrpcGrpc.getGetRewardsOnGoalMethod) == null) {
      synchronized (RewardServiceGrpcGrpc.class) {
        if ((getGetRewardsOnGoalMethod = RewardServiceGrpcGrpc.getGetRewardsOnGoalMethod) == null) {
          RewardServiceGrpcGrpc.getGetRewardsOnGoalMethod = getGetRewardsOnGoalMethod =
              io.grpc.MethodDescriptor.<com.example.demo.protobuf.RewardProto.RewardRequest, com.example.demo.protobuf.RewardProto.RewardResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRewardsOnGoal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.demo.protobuf.RewardProto.RewardRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.demo.protobuf.RewardProto.RewardResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RewardServiceGrpcMethodDescriptorSupplier("GetRewardsOnGoal"))
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
    if ((getGetRewardsOnLevelClearedMethod = RewardServiceGrpcGrpc.getGetRewardsOnLevelClearedMethod) == null) {
      synchronized (RewardServiceGrpcGrpc.class) {
        if ((getGetRewardsOnLevelClearedMethod = RewardServiceGrpcGrpc.getGetRewardsOnLevelClearedMethod) == null) {
          RewardServiceGrpcGrpc.getGetRewardsOnLevelClearedMethod = getGetRewardsOnLevelClearedMethod =
              io.grpc.MethodDescriptor.<com.example.demo.protobuf.RewardProto.RewardRequest, com.example.demo.protobuf.RewardProto.RewardResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRewardsOnLevelCleared"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.demo.protobuf.RewardProto.RewardRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.demo.protobuf.RewardProto.RewardResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RewardServiceGrpcMethodDescriptorSupplier("GetRewardsOnLevelCleared"))
              .build();
        }
      }
    }
    return getGetRewardsOnLevelClearedMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RewardServiceGrpcStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RewardServiceGrpcStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RewardServiceGrpcStub>() {
        @java.lang.Override
        public RewardServiceGrpcStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RewardServiceGrpcStub(channel, callOptions);
        }
      };
    return RewardServiceGrpcStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RewardServiceGrpcBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RewardServiceGrpcBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RewardServiceGrpcBlockingStub>() {
        @java.lang.Override
        public RewardServiceGrpcBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RewardServiceGrpcBlockingStub(channel, callOptions);
        }
      };
    return RewardServiceGrpcBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RewardServiceGrpcFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RewardServiceGrpcFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RewardServiceGrpcFutureStub>() {
        @java.lang.Override
        public RewardServiceGrpcFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RewardServiceGrpcFutureStub(channel, callOptions);
        }
      };
    return RewardServiceGrpcFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class RewardServiceGrpcImplBase implements io.grpc.BindableService {

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
  public static final class RewardServiceGrpcStub extends io.grpc.stub.AbstractAsyncStub<RewardServiceGrpcStub> {
    private RewardServiceGrpcStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RewardServiceGrpcStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RewardServiceGrpcStub(channel, callOptions);
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
  public static final class RewardServiceGrpcBlockingStub extends io.grpc.stub.AbstractBlockingStub<RewardServiceGrpcBlockingStub> {
    private RewardServiceGrpcBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RewardServiceGrpcBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RewardServiceGrpcBlockingStub(channel, callOptions);
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
  public static final class RewardServiceGrpcFutureStub extends io.grpc.stub.AbstractFutureStub<RewardServiceGrpcFutureStub> {
    private RewardServiceGrpcFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RewardServiceGrpcFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RewardServiceGrpcFutureStub(channel, callOptions);
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
    private final RewardServiceGrpcImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RewardServiceGrpcImplBase serviceImpl, int methodId) {
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

  private static abstract class RewardServiceGrpcBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RewardServiceGrpcBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.demo.protobuf.RewardServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RewardServiceGrpc");
    }
  }

  private static final class RewardServiceGrpcFileDescriptorSupplier
      extends RewardServiceGrpcBaseDescriptorSupplier {
    RewardServiceGrpcFileDescriptorSupplier() {}
  }

  private static final class RewardServiceGrpcMethodDescriptorSupplier
      extends RewardServiceGrpcBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RewardServiceGrpcMethodDescriptorSupplier(String methodName) {
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
      synchronized (RewardServiceGrpcGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RewardServiceGrpcFileDescriptorSupplier())
              .addMethod(getGetRewardsOnGoalMethod())
              .addMethod(getGetRewardsOnLevelClearedMethod())
              .build();
        }
      }
    }
    return result;
  }
}
