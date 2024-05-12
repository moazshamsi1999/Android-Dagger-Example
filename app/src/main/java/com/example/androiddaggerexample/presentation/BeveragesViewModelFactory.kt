
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androiddaggerexample.domain.GetPopularBeveragesUseCase
import com.example.androiddaggerexample.presentation.BeveragesViewModel

class BeveragesViewModelFactory(
    private val getPopularBeveragesUseCase: GetPopularBeveragesUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return BeveragesViewModel(
            getPopularBeveragesUseCase
        ) as T
    }
}
