package lotto.domain;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber, Lotto winningLotto) {
        validateRange(bonusNumber);
        validateDuplicate(bonusNumber, winningLotto);
        this.bonusNumber = bonusNumber;
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("로또 번호의 숫자 범위는 1~45까지입니다.");
        }
    }

    private void validateDuplicate(int bonusNumber, Lotto winningLotto) {
        if (winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호와 중복됩니다.");
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
