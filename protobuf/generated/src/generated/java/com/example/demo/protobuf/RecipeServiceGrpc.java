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
    value = "by gRPC proto compiler (version 1.30.2)",
    comments = "Source: recipeService.proto")
public final class RecipeServiceGrpc {

  private RecipeServiceGrpc() {}

  public static final String SERVICE_NAME = "RecipeService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.example.demo.protobuf.RecipeProto.RecipeResearchResponse> getFindAllMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FindAll",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.example.demo.protobuf.RecipeProto.RecipeResearchResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.example.demo.protobuf.RecipeProto.RecipeResearchResponse> getFindAllMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.example.demo.protobuf.RecipeProto.RecipeResearchResponse> getFindAllMethod;
    if ((getFindAllMethod = RecipeServiceGrpc.getFindAllMethod) == null) {
      synchronized (RecipeServiceGrpc.class) {
        if ((getFindAllMethod = RecipeServiceGrpc.getFindAllMethod) == null) {
          RecipeServiceGrpc.getFindAllMethod = getFindAllMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.example.demo.protobuf.RecipeProto.RecipeResearchResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FindAll"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.demo.protobuf.RecipeProto.RecipeResearchResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RecipeServiceMethodDescriptorSupplier("FindAll"))
              .build();
        }
      }
    }
    return getFindAllMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.demo.protobuf.RecipeProto.RecipeInitRequest,
      com.google.protobuf.Empty> getInitMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Init",
      requestType = com.example.demo.protobuf.RecipeProto.RecipeInitRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.demo.protobuf.RecipeProto.RecipeInitRequest,
      com.google.protobuf.Empty> getInitMethod() {
    io.grpc.MethodDescriptor<com.example.demo.protobuf.RecipeProto.RecipeInitRequest, com.google.protobuf.Empty> getInitMethod;
    if ((getInitMethod = RecipeServiceGrpc.getInitMethod) == null) {
      synchronized (RecipeServiceGrpc.class) {
        if ((getInitMethod = RecipeServiceGrpc.getInitMethod) == null) {
          RecipeServiceGrpc.getInitMethod = getInitMethod =
              io.grpc.MethodDescriptor.<com.example.demo.protobuf.RecipeProto.RecipeInitRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Init"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.demo.protobuf.RecipeProto.RecipeInitRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new RecipeServiceMethodDescriptorSupplier("Init"))
              .build();
        }
      }
    }
    return getInitMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.google.protobuf.Empty> getRemoveAllRecipesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RemoveAllRecipes",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.google.protobuf.Empty> getRemoveAllRecipesMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.google.protobuf.Empty> getRemoveAllRecipesMethod;
    if ((getRemoveAllRecipesMethod = RecipeServiceGrpc.getRemoveAllRecipesMethod) == null) {
      synchronized (RecipeServiceGrpc.class) {
        if ((getRemoveAllRecipesMethod = RecipeServiceGrpc.getRemoveAllRecipesMethod) == null) {
          RecipeServiceGrpc.getRemoveAllRecipesMethod = getRemoveAllRecipesMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RemoveAllRecipes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new RecipeServiceMethodDescriptorSupplier("RemoveAllRecipes"))
              .build();
        }
      }
    }
    return getRemoveAllRecipesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.demo.protobuf.RecipeProto.RecipeRemoveRequest,
      com.google.protobuf.Empty> getRemoveRecipeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RemoveRecipe",
      requestType = com.example.demo.protobuf.RecipeProto.RecipeRemoveRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.demo.protobuf.RecipeProto.RecipeRemoveRequest,
      com.google.protobuf.Empty> getRemoveRecipeMethod() {
    io.grpc.MethodDescriptor<com.example.demo.protobuf.RecipeProto.RecipeRemoveRequest, com.google.protobuf.Empty> getRemoveRecipeMethod;
    if ((getRemoveRecipeMethod = RecipeServiceGrpc.getRemoveRecipeMethod) == null) {
      synchronized (RecipeServiceGrpc.class) {
        if ((getRemoveRecipeMethod = RecipeServiceGrpc.getRemoveRecipeMethod) == null) {
          RecipeServiceGrpc.getRemoveRecipeMethod = getRemoveRecipeMethod =
              io.grpc.MethodDescriptor.<com.example.demo.protobuf.RecipeProto.RecipeRemoveRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RemoveRecipe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.demo.protobuf.RecipeProto.RecipeRemoveRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new RecipeServiceMethodDescriptorSupplier("RemoveRecipe"))
              .build();
        }
      }
    }
    return getRemoveRecipeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RecipeServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RecipeServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RecipeServiceStub>() {
        @java.lang.Override
        public RecipeServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RecipeServiceStub(channel, callOptions);
        }
      };
    return RecipeServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RecipeServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RecipeServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RecipeServiceBlockingStub>() {
        @java.lang.Override
        public RecipeServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RecipeServiceBlockingStub(channel, callOptions);
        }
      };
    return RecipeServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RecipeServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RecipeServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RecipeServiceFutureStub>() {
        @java.lang.Override
        public RecipeServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RecipeServiceFutureStub(channel, callOptions);
        }
      };
    return RecipeServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class RecipeServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void findAll(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.example.demo.protobuf.RecipeProto.RecipeResearchResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getFindAllMethod(), responseObserver);
    }

    /**
     */
    public void init(com.example.demo.protobuf.RecipeProto.RecipeInitRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getInitMethod(), responseObserver);
    }

    /**
     */
    public void removeAllRecipes(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getRemoveAllRecipesMethod(), responseObserver);
    }

    /**
     */
    public void removeRecipe(com.example.demo.protobuf.RecipeProto.RecipeRemoveRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getRemoveRecipeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getFindAllMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                com.example.demo.protobuf.RecipeProto.RecipeResearchResponse>(
                  this, METHODID_FIND_ALL)))
          .addMethod(
            getInitMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.demo.protobuf.RecipeProto.RecipeInitRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_INIT)))
          .addMethod(
            getRemoveAllRecipesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                com.google.protobuf.Empty>(
                  this, METHODID_REMOVE_ALL_RECIPES)))
          .addMethod(
            getRemoveRecipeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.demo.protobuf.RecipeProto.RecipeRemoveRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_REMOVE_RECIPE)))
          .build();
    }
  }

  /**
   */
  public static final class RecipeServiceStub extends io.grpc.stub.AbstractAsyncStub<RecipeServiceStub> {
    private RecipeServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecipeServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecipeServiceStub(channel, callOptions);
    }

    /**
     */
    public void findAll(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.example.demo.protobuf.RecipeProto.RecipeResearchResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getFindAllMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void init(com.example.demo.protobuf.RecipeProto.RecipeInitRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInitMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void removeAllRecipes(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRemoveAllRecipesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void removeRecipe(com.example.demo.protobuf.RecipeProto.RecipeRemoveRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRemoveRecipeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RecipeServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<RecipeServiceBlockingStub> {
    private RecipeServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecipeServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecipeServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.demo.protobuf.RecipeProto.RecipeResearchResponse findAll(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), getFindAllMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty init(com.example.demo.protobuf.RecipeProto.RecipeInitRequest request) {
      return blockingUnaryCall(
          getChannel(), getInitMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty removeAllRecipes(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), getRemoveAllRecipesMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty removeRecipe(com.example.demo.protobuf.RecipeProto.RecipeRemoveRequest request) {
      return blockingUnaryCall(
          getChannel(), getRemoveRecipeMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RecipeServiceFutureStub extends io.grpc.stub.AbstractFutureStub<RecipeServiceFutureStub> {
    private RecipeServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecipeServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecipeServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.demo.protobuf.RecipeProto.RecipeResearchResponse> findAll(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getFindAllMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> init(
        com.example.demo.protobuf.RecipeProto.RecipeInitRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getInitMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> removeAllRecipes(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getRemoveAllRecipesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> removeRecipe(
        com.example.demo.protobuf.RecipeProto.RecipeRemoveRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRemoveRecipeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FIND_ALL = 0;
  private static final int METHODID_INIT = 1;
  private static final int METHODID_REMOVE_ALL_RECIPES = 2;
  private static final int METHODID_REMOVE_RECIPE = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RecipeServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RecipeServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FIND_ALL:
          serviceImpl.findAll((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.example.demo.protobuf.RecipeProto.RecipeResearchResponse>) responseObserver);
          break;
        case METHODID_INIT:
          serviceImpl.init((com.example.demo.protobuf.RecipeProto.RecipeInitRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_REMOVE_ALL_RECIPES:
          serviceImpl.removeAllRecipes((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_REMOVE_RECIPE:
          serviceImpl.removeRecipe((com.example.demo.protobuf.RecipeProto.RecipeRemoveRequest) request,
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

  private static abstract class RecipeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RecipeServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.demo.protobuf.RecipeServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RecipeService");
    }
  }

  private static final class RecipeServiceFileDescriptorSupplier
      extends RecipeServiceBaseDescriptorSupplier {
    RecipeServiceFileDescriptorSupplier() {}
  }

  private static final class RecipeServiceMethodDescriptorSupplier
      extends RecipeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RecipeServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (RecipeServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RecipeServiceFileDescriptorSupplier())
              .addMethod(getFindAllMethod())
              .addMethod(getInitMethod())
              .addMethod(getRemoveAllRecipesMethod())
              .addMethod(getRemoveRecipeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
