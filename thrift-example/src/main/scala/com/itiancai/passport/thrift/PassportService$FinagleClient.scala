/**
 * Generated by Scrooge
 *   version: 4.1.0
 *   rev: 87b84f89477a4737c8d57580a1e8bdaeac529b19
 *   built at: 20150928-114741
 */
package com.itiancai.passport.thrift

import com.twitter.finagle.SourcedException
import com.twitter.finagle.stats.{NullStatsReceiver, StatsReceiver}
import com.twitter.finagle.thrift.{Protocols, ThriftClientRequest}
import com.twitter.scrooge.{ThriftStruct, ThriftStructCodec}
import com.twitter.util.{Future, Return, Throw, Throwables}
import java.nio.ByteBuffer
import java.util.Arrays
import org.apache.thrift.protocol._
import org.apache.thrift.TApplicationException
import org.apache.thrift.transport.{TMemoryBuffer, TMemoryInputTransport}
import scala.collection.{Map, Set}

import scala.language.higherKinds


@javax.annotation.Generated(value = Array("com.twitter.scrooge.Compiler"))
class PassportService$FinagleClient(
    val service: com.twitter.finagle.Service[ThriftClientRequest, Array[Byte]],
    val protocolFactory: TProtocolFactory = Protocols.binaryFactory(),
    val serviceName: String = "PassportService",
    stats: StatsReceiver = NullStatsReceiver
) extends PassportService[Future] {
  import PassportService._

  protected def encodeRequest(name: String, args: ThriftStruct) = {
    val buf = new TMemoryBuffer(512)
    val oprot = protocolFactory.getProtocol(buf)

    oprot.writeMessageBegin(new TMessage(name, TMessageType.CALL, 0))
    args.write(oprot)
    oprot.writeMessageEnd()

    val bytes = Arrays.copyOfRange(buf.getArray, 0, buf.length)
    new ThriftClientRequest(bytes, false)
  }

  protected def decodeResponse[T <: ThriftStruct](resBytes: Array[Byte], codec: ThriftStructCodec[T]) = {
    val iprot = protocolFactory.getProtocol(new TMemoryInputTransport(resBytes))
    val msg = iprot.readMessageBegin()
    try {
      if (msg.`type` == TMessageType.EXCEPTION) {
        val exception = TApplicationException.read(iprot) match {
          case sourced: SourcedException =>
            if (serviceName != "") sourced.serviceName = serviceName
            sourced
          case e => e
        }
        throw exception
      } else {
        codec.decode(iprot)
      }
    } finally {
      iprot.readMessageEnd()
    }
  }

  protected def missingResult(name: String) = {
    new TApplicationException(
      TApplicationException.MISSING_RESULT,
      name + " failed: unknown result"
    )
  }

  protected def setServiceName(ex: Throwable): Throwable =
    if (this.serviceName == "") ex
    else {
      ex match {
        case se: SourcedException =>
          se.serviceName = this.serviceName
          se
        case _ => ex
      }
    }

  // ----- end boilerplate.

  private[this] val scopedStats = if (serviceName != "") stats.scope(serviceName) else stats
  private[this] object __stats_registerValidate {
    val RequestsCounter = scopedStats.scope("registerValidate").counter("requests")
    val SuccessCounter = scopedStats.scope("registerValidate").counter("success")
    val FailuresCounter = scopedStats.scope("registerValidate").counter("failures")
    val FailuresScope = scopedStats.scope("registerValidate").scope("failures")
  }
  
  def registerValidate(name: String, value: String): Future[com.itiancai.passport.thrift.PassportResult] = {
    __stats_registerValidate.RequestsCounter.incr()
    this.service(encodeRequest("registerValidate", RegisterValidate.Args(name, value))) flatMap { response =>
      val result = decodeResponse(response, RegisterValidate.Result)
      val exception: Future[Nothing] =
        null
  
      if (result.success.isDefined)
        Future.value(result.success.get)
      else if (exception != null)
        exception
      else
        Future.exception(missingResult("registerValidate"))
    } respond {
      case Return(_) =>
        __stats_registerValidate.SuccessCounter.incr()
      case Throw(ex) =>
        setServiceName(ex)
        __stats_registerValidate.FailuresCounter.incr()
        __stats_registerValidate.FailuresScope.counter(Throwables.mkString(ex): _*).incr()
    }
  }
  private[this] object __stats_regist {
    val RequestsCounter = scopedStats.scope("regist").counter("requests")
    val SuccessCounter = scopedStats.scope("regist").counter("success")
    val FailuresCounter = scopedStats.scope("regist").counter("failures")
    val FailuresScope = scopedStats.scope("regist").scope("failures")
  }
  
  def regist(user: com.itiancai.passport.thrift.User): Future[com.itiancai.passport.thrift.PassportResult] = {
    __stats_regist.RequestsCounter.incr()
    this.service(encodeRequest("regist", Regist.Args(user))) flatMap { response =>
      val result = decodeResponse(response, Regist.Result)
      val exception: Future[Nothing] =
        null
  
      if (result.success.isDefined)
        Future.value(result.success.get)
      else if (exception != null)
        exception
      else
        Future.exception(missingResult("regist"))
    } respond {
      case Return(_) =>
        __stats_regist.SuccessCounter.incr()
      case Throw(ex) =>
        setServiceName(ex)
        __stats_regist.FailuresCounter.incr()
        __stats_regist.FailuresScope.counter(Throwables.mkString(ex): _*).incr()
    }
  }
  private[this] object __stats_login {
    val RequestsCounter = scopedStats.scope("login").counter("requests")
    val SuccessCounter = scopedStats.scope("login").counter("success")
    val FailuresCounter = scopedStats.scope("login").counter("failures")
    val FailuresScope = scopedStats.scope("login").scope("failures")
  }
  
  def login(user: com.itiancai.passport.thrift.UserLogin): Future[com.itiancai.passport.thrift.PassportResult] = {
    __stats_login.RequestsCounter.incr()
    this.service(encodeRequest("login", Login.Args(user))) flatMap { response =>
      val result = decodeResponse(response, Login.Result)
      val exception: Future[Nothing] =
        null
  
      if (result.success.isDefined)
        Future.value(result.success.get)
      else if (exception != null)
        exception
      else
        Future.exception(missingResult("login"))
    } respond {
      case Return(_) =>
        __stats_login.SuccessCounter.incr()
      case Throw(ex) =>
        setServiceName(ex)
        __stats_login.FailuresCounter.incr()
        __stats_login.FailuresScope.counter(Throwables.mkString(ex): _*).incr()
    }
  }
  private[this] object __stats_userInfo {
    val RequestsCounter = scopedStats.scope("userInfo").counter("requests")
    val SuccessCounter = scopedStats.scope("userInfo").counter("success")
    val FailuresCounter = scopedStats.scope("userInfo").counter("failures")
    val FailuresScope = scopedStats.scope("userInfo").scope("failures")
  }
  
  def userInfo(userId: Long): Future[com.itiancai.passport.thrift.PassportResult] = {
    __stats_userInfo.RequestsCounter.incr()
    this.service(encodeRequest("userInfo", UserInfo.Args(userId))) flatMap { response =>
      val result = decodeResponse(response, UserInfo.Result)
      val exception: Future[Nothing] =
        null
  
      if (result.success.isDefined)
        Future.value(result.success.get)
      else if (exception != null)
        exception
      else
        Future.exception(missingResult("userInfo"))
    } respond {
      case Return(_) =>
        __stats_userInfo.SuccessCounter.incr()
      case Throw(ex) =>
        setServiceName(ex)
        __stats_userInfo.FailuresCounter.incr()
        __stats_userInfo.FailuresScope.counter(Throwables.mkString(ex): _*).incr()
    }
  }
}
