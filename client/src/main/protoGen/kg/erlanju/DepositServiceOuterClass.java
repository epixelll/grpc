// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: DepositService.proto

package kg.erlanju;

public final class DepositServiceOuterClass {
  private DepositServiceOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_kg_erlanju_DepositRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_kg_erlanju_DepositRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_kg_erlanju_DepositResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_kg_erlanju_DepositResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\024DepositService.proto\022\nkg.erlanju\"\216\001\n\016D" +
      "epositRequest\022\016\n\006userId\030\001 \001(\005\022\016\n\006amount\030" +
      "\002 \001(\001\0225\n\010currency\030\003 \001(\0162#.kg.erlanju.Dep" +
      "ositRequest.Currency\"%\n\010Currency\022\007\n\003EUR\020" +
      "\000\022\007\n\003USD\020\001\022\007\n\003GBP\020\002\"\021\n\017DepositResponse2T" +
      "\n\016DepositService\022B\n\007deposit\022\032.kg.erlanju" +
      ".DepositRequest\032\033.kg.erlanju.DepositResp" +
      "onseB\002P\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_kg_erlanju_DepositRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_kg_erlanju_DepositRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_kg_erlanju_DepositRequest_descriptor,
        new java.lang.String[] { "UserId", "Amount", "Currency", });
    internal_static_kg_erlanju_DepositResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_kg_erlanju_DepositResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_kg_erlanju_DepositResponse_descriptor,
        new java.lang.String[] { });
  }

  // @@protoc_insertion_point(outer_class_scope)
}