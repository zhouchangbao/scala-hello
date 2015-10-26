/**
 * Generated by Scrooge
 *   version: 4.1.0
 *   rev: 87b84f89477a4737c8d57580a1e8bdaeac529b19
 *   built at: 20150928-114741
 */
package com.itiancai.passport.thrift

import com.twitter.finagle.thrift.{Protocols, ThriftClientRequest, ThriftServiceIface}
import com.twitter.scrooge.{TFieldBlob, ThriftResponse, ThriftService, ThriftStruct, ThriftStructCodec3, ThriftStructFieldInfo}
import com.twitter.util.Future
import org.apache.thrift.protocol._

import scala.collection.Map
import scala.collection.immutable.{Map => immutable$Map}
import scala.collection.mutable.{ArrayBuffer => mutable$ArrayBuffer, Buffer => mutable$Buffer, Builder, HashMap => mutable$HashMap, HashSet => mutable$HashSet}
import scala.language.higherKinds


@javax.annotation.Generated(value = Array("com.twitter.scrooge.Compiler"))
trait PassportService[+MM[_]] extends ThriftService {
  
  def hi(word: String): MM[String]
}



object PassportService { self =>

  case class ServiceIface(
      hi : com.twitter.finagle.Service[self.Hi.Args, self.Hi.Result]
  ) extends __ServiceIface

  // This is needed to support service inheritance.
  trait __ServiceIface  {
    def hi : com.twitter.finagle.Service[self.Hi.Args, self.Hi.Result]
  }

  implicit object ServiceIfaceBuilder
    extends com.twitter.finagle.thrift.ServiceIfaceBuilder[ServiceIface] {
      def newServiceIface(
        binaryService: com.twitter.finagle.Service[ThriftClientRequest, Array[Byte]],
        pf: TProtocolFactory = Protocols.binaryFactory(),
        stats: com.twitter.finagle.stats.StatsReceiver
      ): ServiceIface =
        new ServiceIface(
          hi = ThriftServiceIface(self.Hi, binaryService, pf, stats)
      )
  }

  class MethodIface(serviceIface: __ServiceIface)
    extends PassportService[Future] {
    private[this] val __hi_service =
      ThriftServiceIface.resultFilter(self.Hi) andThen serviceIface.hi
    def hi(word: String): Future[String] =
      __hi_service(self.Hi.Args(word))
  }

  implicit object MethodIfaceBuilder
    extends com.twitter.finagle.thrift.MethodIfaceBuilder[ServiceIface, PassportService[Future]] {
    def newMethodIface(serviceIface: ServiceIface): PassportService[Future] =
      new MethodIface(serviceIface)
  }

  object Hi extends com.twitter.scrooge.ThriftMethod {
    
    object Args extends ThriftStructCodec3[Args] {
      private val NoPassthroughFields = immutable$Map.empty[Short, TFieldBlob]
      val Struct = new TStruct("hi_args")
      val WordField = new TField("word", TType.STRING, 1)
      val WordFieldManifest = implicitly[Manifest[String]]
    
      /**
       * Field information in declaration order.
       */
      lazy val fieldInfos: scala.List[ThriftStructFieldInfo] = scala.List[ThriftStructFieldInfo](
        new ThriftStructFieldInfo(
          WordField,
          false,
          false,
          WordFieldManifest,
          _root_.scala.None,
          _root_.scala.None,
          immutable$Map.empty[String, String],
          immutable$Map.empty[String, String]
        )
      )
    
      lazy val structAnnotations: immutable$Map[String, String] =
        immutable$Map.empty[String, String]
    
      /**
       * Checks that all required fields are non-null.
       */
      def validate(_item: Args): Unit = {
      }
    
      def withoutPassthroughFields(original: Args): Args =
        new Args(
          word =
            {
              val field = original.word
              field
            }
        )
    
      override def encode(_item: Args, _oproto: TProtocol): Unit = {
        _item.write(_oproto)
      }
    
      override def decode(_iprot: TProtocol): Args = {
        var word: String = null
        var _passthroughFields: Builder[(Short, TFieldBlob), immutable$Map[Short, TFieldBlob]] = null
        var _done = false
    
        _iprot.readStructBegin()
        while (!_done) {
          val _field = _iprot.readFieldBegin()
          if (_field.`type` == TType.STOP) {
            _done = true
          } else {
            _field.id match {
              case 1 =>
                _field.`type` match {
                  case TType.STRING =>
                    word = readWordValue(_iprot)
                  case _actualType =>
                    val _expectedType = TType.STRING
                    throw new TProtocolException(
                      "Received wrong type for field 'word' (expected=%s, actual=%s).".format(
                        ttypeToString(_expectedType),
                        ttypeToString(_actualType)
                      )
                    )
                }
              case _ =>
                if (_passthroughFields == null)
                  _passthroughFields = immutable$Map.newBuilder[Short, TFieldBlob]
                _passthroughFields += (_field.id -> TFieldBlob.read(_field, _iprot))
            }
            _iprot.readFieldEnd()
          }
        }
        _iprot.readStructEnd()
    
        new Args(
          word,
          if (_passthroughFields == null)
            NoPassthroughFields
          else
            _passthroughFields.result()
        )
      }
    
      def apply(
        word: String
      ): Args =
        new Args(
          word
        )
    
      def unapply(_item: Args): _root_.scala.Option[String] = _root_.scala.Some(_item.word)
    
    
      @inline private def readWordValue(_iprot: TProtocol): String = {
        _iprot.readString()
      }
    
      @inline private def writeWordField(word_item: String, _oprot: TProtocol): Unit = {
        _oprot.writeFieldBegin(WordField)
        writeWordValue(word_item, _oprot)
        _oprot.writeFieldEnd()
      }
    
      @inline private def writeWordValue(word_item: String, _oprot: TProtocol): Unit = {
        _oprot.writeString(word_item)
      }
    
    
    }
    
    class Args(
        val word: String,
        val _passthroughFields: immutable$Map[Short, TFieldBlob])
      extends ThriftStruct
      with scala.Product1[String]
      with java.io.Serializable
    {
      import Args._
      def this(
        word: String
      ) = this(
        word,
        Map.empty
      )
    
      def _1 = word
    
    
    
      override def write(_oprot: TProtocol): Unit = {
        Args.validate(this)
        _oprot.writeStructBegin(Struct)
        if (word ne null) writeWordField(word, _oprot)
        if (_passthroughFields.nonEmpty) {
          _passthroughFields.values.foreach { _.write(_oprot) }
        }
        _oprot.writeFieldStop()
        _oprot.writeStructEnd()
      }
    
      def copy(
        word: String = this.word,
        _passthroughFields: immutable$Map[Short, TFieldBlob] = this._passthroughFields
      ): Args =
        new Args(
          word,
          _passthroughFields
        )
    
      override def canEqual(other: Any): Boolean = other.isInstanceOf[Args]
    
      override def equals(other: Any): Boolean =
        canEqual(other) &&
          _root_.scala.runtime.ScalaRunTime._equals(this, other) &&
          _passthroughFields == other.asInstanceOf[Args]._passthroughFields
    
      override def hashCode: Int = _root_.scala.runtime.ScalaRunTime._hashCode(this)
    
      override def toString: String = _root_.scala.runtime.ScalaRunTime._toString(this)
    
    
      override def productArity: Int = 1
    
      override def productElement(n: Int): Any = n match {
        case 0 => this.word
        case _ => throw new IndexOutOfBoundsException(n.toString)
      }
    
      override def productPrefix: String = "Args"
    }

    type SuccessType = String
    
    object Result extends ThriftStructCodec3[Result] {
      private val NoPassthroughFields = immutable$Map.empty[Short, TFieldBlob]
      val Struct = new TStruct("hi_result")
      val SuccessField = new TField("success", TType.STRING, 0)
      val SuccessFieldManifest = implicitly[Manifest[String]]
    
      /**
       * Field information in declaration order.
       */
      lazy val fieldInfos: scala.List[ThriftStructFieldInfo] = scala.List[ThriftStructFieldInfo](
        new ThriftStructFieldInfo(
          SuccessField,
          true,
          false,
          SuccessFieldManifest,
          _root_.scala.None,
          _root_.scala.None,
          immutable$Map.empty[String, String],
          immutable$Map.empty[String, String]
        )
      )
    
      lazy val structAnnotations: immutable$Map[String, String] =
        immutable$Map.empty[String, String]
    
      /**
       * Checks that all required fields are non-null.
       */
      def validate(_item: Result): Unit = {
      }
    
      def withoutPassthroughFields(original: Result): Result =
        new Result(
          success =
            {
              val field = original.success
              field.map { field =>
                field
              }
            }
        )
    
      override def encode(_item: Result, _oproto: TProtocol): Unit = {
        _item.write(_oproto)
      }
    
      override def decode(_iprot: TProtocol): Result = {
        var success: _root_.scala.Option[String] = _root_.scala.None
        var _passthroughFields: Builder[(Short, TFieldBlob), immutable$Map[Short, TFieldBlob]] = null
        var _done = false
    
        _iprot.readStructBegin()
        while (!_done) {
          val _field = _iprot.readFieldBegin()
          if (_field.`type` == TType.STOP) {
            _done = true
          } else {
            _field.id match {
              case 0 =>
                _field.`type` match {
                  case TType.STRING =>
                    success = _root_.scala.Some(readSuccessValue(_iprot))
                  case _actualType =>
                    val _expectedType = TType.STRING
                    throw new TProtocolException(
                      "Received wrong type for field 'success' (expected=%s, actual=%s).".format(
                        ttypeToString(_expectedType),
                        ttypeToString(_actualType)
                      )
                    )
                }
              case _ =>
                if (_passthroughFields == null)
                  _passthroughFields = immutable$Map.newBuilder[Short, TFieldBlob]
                _passthroughFields += (_field.id -> TFieldBlob.read(_field, _iprot))
            }
            _iprot.readFieldEnd()
          }
        }
        _iprot.readStructEnd()
    
        new Result(
          success,
          if (_passthroughFields == null)
            NoPassthroughFields
          else
            _passthroughFields.result()
        )
      }
    
      def apply(
        success: _root_.scala.Option[String] = _root_.scala.None
      ): Result =
        new Result(
          success
        )
    
      def unapply(_item: Result): _root_.scala.Option[_root_.scala.Option[String]] = _root_.scala.Some(_item.success)
    
    
      @inline private def readSuccessValue(_iprot: TProtocol): String = {
        _iprot.readString()
      }
    
      @inline private def writeSuccessField(success_item: String, _oprot: TProtocol): Unit = {
        _oprot.writeFieldBegin(SuccessField)
        writeSuccessValue(success_item, _oprot)
        _oprot.writeFieldEnd()
      }
    
      @inline private def writeSuccessValue(success_item: String, _oprot: TProtocol): Unit = {
        _oprot.writeString(success_item)
      }
    
    
    }
    
    class Result(
        val success: _root_.scala.Option[String],
        val _passthroughFields: immutable$Map[Short, TFieldBlob])
      extends ThriftResponse[String] with ThriftStruct
      with scala.Product1[Option[String]]
      with java.io.Serializable
    {
      import Result._
      def this(
        success: _root_.scala.Option[String] = _root_.scala.None
      ) = this(
        success,
        Map.empty
      )
    
      def _1 = success
    
      def successField: Option[String] = success
      def exceptionFields: Iterable[Option[com.twitter.scrooge.ThriftException]] = Seq()
    
    
      override def write(_oprot: TProtocol): Unit = {
        Result.validate(this)
        _oprot.writeStructBegin(Struct)
        if (success.isDefined) writeSuccessField(success.get, _oprot)
        if (_passthroughFields.nonEmpty) {
          _passthroughFields.values.foreach { _.write(_oprot) }
        }
        _oprot.writeFieldStop()
        _oprot.writeStructEnd()
      }
    
      def copy(
        success: _root_.scala.Option[String] = this.success,
        _passthroughFields: immutable$Map[Short, TFieldBlob] = this._passthroughFields
      ): Result =
        new Result(
          success,
          _passthroughFields
        )
    
      override def canEqual(other: Any): Boolean = other.isInstanceOf[Result]
    
      override def equals(other: Any): Boolean =
        canEqual(other) &&
          _root_.scala.runtime.ScalaRunTime._equals(this, other) &&
          _passthroughFields == other.asInstanceOf[Result]._passthroughFields
    
      override def hashCode: Int = _root_.scala.runtime.ScalaRunTime._hashCode(this)
    
      override def toString: String = _root_.scala.runtime.ScalaRunTime._toString(this)
    
    
      override def productArity: Int = 1
    
      override def productElement(n: Int): Any = n match {
        case 0 => this.success
        case _ => throw new IndexOutOfBoundsException(n.toString)
      }
    
      override def productPrefix: String = "Result"
    }

    val name = "hi"
    val serviceName = "PassportService"
    val argsCodec = Args
    val responseCodec = Result
    val oneway = false
  }

  // Compatibility aliases.
  val hi$args = Hi.Args
  type hi$args = Hi.Args

  val hi$result = Hi.Result
  type hi$result = Hi.Result


  trait FutureIface extends PassportService[Future] {
    
    def hi(word: String): Future[String]
  }

  class FinagledClient(
      service: com.twitter.finagle.Service[ThriftClientRequest, Array[Byte]],
      protocolFactory: TProtocolFactory = Protocols.binaryFactory(),
      serviceName: String = "PassportService",
      stats: com.twitter.finagle.stats.StatsReceiver = com.twitter.finagle.stats.NullStatsReceiver)
    extends PassportService$FinagleClient(
      service,
      protocolFactory,
      serviceName,
      stats)
    with FutureIface

  class FinagledService(
      iface: FutureIface,
      protocolFactory: TProtocolFactory)
    extends PassportService$FinagleService(
      iface,
      protocolFactory)
}