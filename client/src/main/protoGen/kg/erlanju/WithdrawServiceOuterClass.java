// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: WithdrawService.proto

package kg.erlanju;

public final class WithdrawServiceOuterClass {
  private WithdrawServiceOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_kg_erlanju_WithdrawRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_kg_erlanju_WithdrawRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_kg_erlanju_WithdrawResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_kg_erlanju_WithdrawResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\025WithdrawService.proto\022\nkg.erlanju\"\220\001\n\017" +
      "WithdrawRequest\022\016\n\006userId\030\001 \001(\005\022\016\n\006amoun" +
      "t\030\002 \001(\001\0226\n\010currency\030\003 \001(\0162$.kg.erlanju.W" +
      "ithdrawRequest.Currency\"%\n\010Currency\022\007\n\003E" +
      "UR\020\000\022\007\n\003USD\020\001\022\007\n\003GBP\020\002\"\022\n\020WithdrawRespon" +
      "se2X\n\017WithdrawService\022E\n\010withdraw\022\033.kg.e" +
      "rlanju.WithdrawRequest\032\034.kg.erlanju.With" +
      "drawResponseB\002P\001b\006proto3"
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
    internal_static_kg_erlanju_WithdrawRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_kg_erlanju_WithdrawRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_kg_erlanju_WithdrawRequest_descriptor,
        new java.lang.String[] { "UserId", "Amount", "Currency", });
    internal_static_kg_erlanju_WithdrawResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_kg_erlanju_WithdrawResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_kg_erlanju_WithdrawResponse_descriptor,
        new java.lang.String[] { });
  }

  // @@protoc_insertion_point(outer_class_scope)
}