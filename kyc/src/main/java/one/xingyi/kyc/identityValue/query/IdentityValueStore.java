package one.xingyi.kyc.identityValue.query;
import one.xingyi.core.utils.MapUtils;
import one.xingyi.kyc.identityValue.command.server.domain.IdentityPost;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class IdentityValueStore {
    final Object lock = new Object();
    final Map<String, List<ValueAndDate>> identityToValue = new HashMap<>();
    final Map<String, String> valueToIdentity = new HashMap<>();

    public void put(IdentityPost identity) {
        synchronized (lock) {
            MapUtils.add(identityToValue, identity.id(), new ValueAndDate(identity.value(), identity.date()));
            valueToIdentity.put(identity.value(), identity.id());

        }
    }

    public Optional<ValueAndDate> getLatest(String id) {
        synchronized (lock) {
            return Optional.ofNullable(identityToValue.get(id)).map(list -> list.get(list.size() - 1));
        }
    }

    public Optional<String> getIdentity(String value){
        synchronized (lock){
            return Optional.ofNullable(valueToIdentity.get(value));
        }
    }
}

