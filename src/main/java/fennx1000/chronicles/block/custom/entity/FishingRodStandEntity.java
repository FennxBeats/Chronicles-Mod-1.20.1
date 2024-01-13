package fennx1000.chronicles.block.custom.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

public class FishingRodStandEntity extends LootableContainerBlockEntity {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(2,ItemStack.EMPTY);

    private static final int SLOT1 = 0;
    private static final int SLOT2 = 1;
    private static final int SLOT3 = 2;
    private static final int SLOT4 = 3;
    private static final int SLOT5 = 4;

    public FishingRodStandEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.FISHING_ROD_STAND_BLOCK_ENTITY, blockPos, blockState);
    }

    @Override
    protected DefaultedList<ItemStack> getInvStackList() {
        return this.inventory;
    }

    @Override
    protected void setInvStackList(DefaultedList<ItemStack> list) {

    }

    @Override
    protected Text getContainerName() {
        return Text.literal("Fishing Rod Stand");
    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return GenericContainerScreenHandler.createGeneric9x3(syncId, playerInventory, this);
    }

    @Override
    public int size() {
        return 5;
    }
}
