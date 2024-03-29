package br.com.cvj.discovr.data.local.datastore.user.preferences

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import br.com.cvj.discovr.ProtoUserPreferences
import com.google.protobuf.InvalidProtocolBufferException
import java.io.InputStream
import java.io.OutputStream
import javax.inject.Inject

/**
 * [ProtoUserPreferencesSerializer] is used to serialize/deserialize from Proto Datastore,
 * in particular the [ProtoUserPreferences] datastore.
 *
 * see more at [Proto Datastore](https://developer.android.com/topic/libraries/architecture/datastore#proto-create)
 */
class ProtoUserPreferencesSerializer @Inject constructor() : Serializer<ProtoUserPreferences> {
    override val defaultValue: ProtoUserPreferences = ProtoUserPreferences.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): ProtoUserPreferences =
        try {
            ProtoUserPreferences.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }

    override suspend fun writeTo(t: ProtoUserPreferences, output: OutputStream) = t.writeTo(output)
}
